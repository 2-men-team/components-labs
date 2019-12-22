package com.twomen.backend.persistence;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.twomen.backend.Config;
import com.twomen.backend.rest.ServiceUnavailableException;
import org.springframework.http.HttpEntity;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class AuthProvider {
  private static final String AUTH_URL = Config.AUTH_API;
  private static final RestTemplate TEMPLATE = new RestTemplate();

  public String registerUser(String name, String email) {
    JsonObject object = new JsonObject();
    object.addProperty("name", name);
    object.addProperty("email", email);
    String answer = TEMPLATE.postForObject(AUTH_URL + "/register", new HttpEntity<>(object.toString()), String.class);
    return getField(answer, "api_key").getAsString();
  }

  public boolean isValid(String apiKey) {
    RetryTemplate retry = new RetryTemplate();
    TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
    policy.setTimeout(3000);
    retry.setRetryPolicy(policy);

    String answer = retry.execute(
        context -> TEMPLATE.getForObject(AUTH_URL + "/valid?api_key=" + apiKey, String.class),
        context -> {
          throw new ServiceUnavailableException("Auth service is not available");
        });

    return getField(answer, "is_valid").getAsBoolean(); // check if passed api key is valid
  }

  private static JsonElement getField(String s, String field) {
    JsonParser parser = new JsonParser();
    JsonObject obj = parser.parse(s).getAsJsonObject();
    return obj.get(field);
  }
}

package com.twomen.backend.persistence;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class AuthProvider {
  private static final String AUTH_URL = "http://localhost:9092/api";
  private static final RestTemplate TEMPLATE = new RestTemplate();

  public String registerUser(String name, String email) {
    JsonObject object = new JsonObject();
    object.addProperty("name", name);
    object.addProperty("email", email);
    String answer = TEMPLATE.postForObject(AUTH_URL + "/register", new HttpEntity<>(object.toString()), String.class);
    return getField(answer, "api_key").getAsString();
  }

  public boolean isValid(String apiKey) {
    String answer = TEMPLATE.getForObject(AUTH_URL + "/valid?api_key=" + apiKey, String.class);
    return getField(answer, "is_valid").getAsBoolean(); // check if passed api key is valid
  }

  private static JsonElement getField(String s, String field) {
    JsonParser parser = new JsonParser();
    JsonObject obj = parser.parse(s).getAsJsonObject();
    return obj.get(field);
  }
}

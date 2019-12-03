package com.twomen.backend.rest;

import com.google.gson.JsonObject;
import com.twomen.backend.entity.*;
import com.twomen.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthRestController {
  private final AuthService service;

  @Autowired
  public AuthRestController(AuthService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public AuthData register(@RequestBody AuthData data) {
    return service.registerUser(data);
  }

  @GetMapping("/valid")
  public String isValid(@RequestParam("api_key") String apiKey) {
    JsonObject object = new JsonObject();
    object.addProperty("is_valid", service.isValid(apiKey));
    return object.toString();
  }
}
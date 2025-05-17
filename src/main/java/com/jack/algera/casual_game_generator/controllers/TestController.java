package com.jack.algera.casual_game_generator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/test")
  public String test() {
    return "Test successful!";
  }

  @GetMapping("/test/{id}")
  public String testWithId(@PathVariable String id) {
    return "Test successful with ID: " + id;
  }
}

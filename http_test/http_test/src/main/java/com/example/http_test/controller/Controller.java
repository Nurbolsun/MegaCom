package com.example.http_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1/controller")
public class Controller {
  @GetMapping("/getHome")
    public String getHome(){
      return "HomePage 1 for my students";
  }
  @GetMapping("/newProject")
  public  String createNewProject(){
    return "Intellij Idea";
  }
}

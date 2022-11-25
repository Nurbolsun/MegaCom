package com.example.Test_Maven_New.controllers;

import com.example.Test_Maven_New.models.Person;
import com.example.Test_Maven_New.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1/person")
public class PersonControllers {

        PersonService personService = PersonService.INSTANCE;
        @GetMapping("/get")
        public Person getCreatePerson(){
            return personService.getPerson();
        }
    }


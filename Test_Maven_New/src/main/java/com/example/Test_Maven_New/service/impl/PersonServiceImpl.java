package com.example.Test_Maven_New.service.impl;

import com.example.Test_Maven_New.models.Person;
import com.example.Test_Maven_New.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class PersonServiceImpl implements PersonService {

    @Override
    public Person getPerson() {
        Person person = new Person(1l, "Baktilek", 27, 2500);
        return person;
    }
}

package com.example.Test_Maven_New.service;

import com.example.Test_Maven_New.models.Person;
import com.example.Test_Maven_New.service.impl.PersonServiceImpl;

public interface PersonService {
    PersonService INSTANCE = new PersonServiceImpl();
    Person getPerson();


}

package com.example.http_test;

import com.example.http_test.microservice.OkHttpConnection;
import com.example.http_test.models.Person;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        OkHttpConnection connection = new OkHttpConnection();

        String response = connection.getJson();


        Gson gson = new Gson();

      //   person= gson.fromJson(response,Person.class);

        System.out.println(person);
    }
}

package service.impl;

import microservices.OkHttoConnection;
import service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public String getJSon() {
        OkHttoConnection connection = new OkHttoConnection();
        String response = connection.getJson();

        return null;
    }
}

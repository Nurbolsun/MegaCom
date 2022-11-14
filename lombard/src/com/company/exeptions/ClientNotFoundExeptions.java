package com.company.exeptions;

public class ClientNotFoundExeptions extends RuntimeException {
    public ClientNotFoundExeptions(String message) {
        super(message);
    }
}

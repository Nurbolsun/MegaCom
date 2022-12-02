package com.example.demo_beans.service.impl;

import com.example.demo_beans.service.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void writeLog(){
        System.out.println("Console Logger work");
    }
}

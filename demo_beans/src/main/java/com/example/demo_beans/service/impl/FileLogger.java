package com.example.demo_beans.service.impl;

import com.example.demo_beans.service.Logger;

import java.io.File;

public class FileLogger implements Logger {
    private File file;
    public FileLogger(File file) {
        this.file = file;
    }

    @Override
    public void writeLog() {
        System.out.println("File logger work");
    }
}

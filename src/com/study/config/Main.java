package com.study.config;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();
        Test test = new Test();
        config.setProperties(test);
        System.out.println(test.toString());
    }
}
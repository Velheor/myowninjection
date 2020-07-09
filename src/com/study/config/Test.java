package com.study.config;

public class Test {
    @ConfigProperty("oldBookDays")
    private String oldBookDays;

    @Override
    public String toString() {
        return ("" + oldBookDays);
    }
}

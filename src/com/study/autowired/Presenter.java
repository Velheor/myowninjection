package com.study.autowired;

public class Presenter {
    @Autowired
    Boundary boundary;

    @Override
    public String toString() {
        return "Presenter{" + "boundary" + boundary + "}";
    }
}

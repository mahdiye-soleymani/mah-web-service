package com.clarity.restfulwebservice.model;

public class Hello {

    private String massage;
    private String name;

    public Hello(String message) {
        this.massage=message;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "massage='" + massage + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

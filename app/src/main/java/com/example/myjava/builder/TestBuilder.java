package com.example.myjava.builder;

public class TestBuilder {

    Person person = new Person.Builder().
            setAge("age")
            .setName("name")
            .builder();


}

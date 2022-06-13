package com.example.myjava.builder;

public class Person {
    private String name;
    private String age;

    public Person(Builder builder) {
        name = builder.name;
        age = builder.age;
    }

    public static class Builder {
        private String name;
        private String age;

        public Builder setName(String n) {
            name = n;
            return this;
        }

        public Builder setAge(String a) {
            age = a;
            return this;
        }

        public Person builder() {
            return new Person(this);
        }

    }


}

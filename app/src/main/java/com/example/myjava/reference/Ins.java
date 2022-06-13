package com.example.myjava.reference;

public class Ins {

    private Ins() {
    }

    public static Ins getInstance() {
        return InstanceIns.mInstance;
    }

    private static class InstanceIns {
        private static Ins mInstance = new Ins();
    }

}

package com.example.myjava;

public class MyTest3 {

    static boolean b = false;

    public static void main(String[] args) {

        System.out.println("xxxxxx");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaaaaa");
                while (!b) {

                }
                System.out.println("eeeeeeeeeeeeeee");
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        b = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("changestart");
                b = true;
                System.out.println("changeEnd");
            }
        }).start();

    }


}

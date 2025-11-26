package org.example.threaddemo;

public class Main {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass("A");
        MyClass obj2 = new MyClass("B");
        MyClass obj3 = new MyClass("C");

        obj1.start();
        obj2.start();
        obj3.start();
        System.out.println("Thread 1 IsAlive: " + obj1.isAlive());
        

    }
}

package org.example.threaddemo;

public class MyClass extends Thread {
    public MyClass(String name) {
        super(name);
    }
    public void run() {
        for (int i = 0; i < 10; i++) {}
    }
}

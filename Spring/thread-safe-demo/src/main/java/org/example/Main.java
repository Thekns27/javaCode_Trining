package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TwoString twoString = new TwoString();
        new MyThreadClass("Hello","Coders",twoString);
        new MyThreadClass("Hi  ","Countrymen",twoString);
        new MyThreadClass("Happy","Coding!",twoString);


    }
}
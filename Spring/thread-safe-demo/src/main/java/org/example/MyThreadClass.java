package org.example;

public class MyThreadClass extends Thread {
    private String str1;
    private String str2;
    private TwoString twoString;

    public MyThreadClass(String str1, String str2,TwoString twoString) {
        this.str1 = str1;
        this.str2 = str2;
        this.twoString= twoString;
        start();
    }
    public void run() {
     //   TwoString twoString = new TwoString();
        synchronized (twoString) {
            TwoString.printTwoString(str1, str2);
        }

    }
}

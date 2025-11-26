package org.example;

public class TwoString {
    public synchronized static void printTwoString(String strs1, String str2) {
        System.out.println(strs1 );
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        System.out.println(str2 );
    }
}

package org.example.reactivedemo.util;



public class EntityUtil {

    public static void pauseTime(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.automation.utility;


public class Sleep {

    public static void sleep(Integer sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

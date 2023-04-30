package org.example.util;

import java.util.Random;

public class LogSleeper {

    public static void logSleep(long millSeconds) {
        System.out.println("sleep......"+millSeconds);
        try {
            Thread.sleep(millSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void randomSleep() {
        long millSeconds = new Random().nextInt(5000);
        logSleep(millSeconds);
    }

    public static void sleep(long millSeconds) {
        try {
            Thread.sleep(millSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

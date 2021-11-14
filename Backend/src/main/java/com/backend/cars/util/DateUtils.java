package com.backend.cars.util;

public class DateUtils {
    public static int getCurrentTimeSecond() {
        long current = System.currentTimeMillis() / 1000L;
        return (int) current;
    }

}

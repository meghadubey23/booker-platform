package com.automation.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeCapture {
    public static String screenshotTime() {
        // Get the current time
        LocalDateTime currentTime = LocalDateTime.now();

        // Format the current time using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyymmddhhmmss");

        // Print the formatted time
        return currentTime.format(formatter) + ".png";
    }
}

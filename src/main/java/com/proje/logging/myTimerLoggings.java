package com.proje.logging;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {

    private static final Logger debugLogger = LogManager.getLogger("DebugLogger");
    private static final Logger infoLogger = LogManager.getLogger("InfoLogger");
    private static final Logger errorLogger = LogManager.getLogger("ErrorLogger");

    public static void main(String[] args) {
    	
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            	LocalDateTime now = LocalDateTime.now();
                if (now.getMinute() != 0 && now.getSecond() != 0) {
                debugLogger.debug(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
          }
        }, 0, 1000);
  
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                if (now.getMinute() != 0 && now.getSecond() == 0  ) {
                    infoLogger.info(now.format(DateTimeFormatter.ofPattern("HH:mm:00")));
                }
            }
        }, 0, 1000);
     
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                if (now.getMinute() == 0 && now.getSecond() == 0) {
                    errorLogger.error(now.format(DateTimeFormatter.ofPattern("HH:00:00")));
                }
            }
        }, 0, 1000);
    }
}


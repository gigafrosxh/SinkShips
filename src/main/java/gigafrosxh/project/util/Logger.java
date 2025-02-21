package gigafrosxh.project.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    public Logger() {
        String time = (LocalDateTime.now()).getHour() + ":" + (LocalDateTime.now()).getMinute() + ":" + (LocalDateTime.now()).getSecond();

        writeLog("-----------------New Log Start--------------------", time);
    }

    /**
     * {@code Logger().info(String msg)} gets a message wich is printed out as a log
     * @param msg The input message
     */
    public void info(String msg) {
        String time = (LocalDateTime.now()).getHour() + ":" + (LocalDateTime.now()).getMinute() + ":" + (LocalDateTime.now()).getSecond();

        System.out.println("\033[32m[\033[34m" + time + "\033[32m]" + " \033[34m" + msg);
        writeLog(msg, time);
    }
    /**
     * {@code Logger().info(String msg)} gets a message wich is printed out as an error
     * @param msg The input message
     */
    public void error(String msg) {
        String time = (LocalDateTime.now()).getHour() + ":" + (LocalDateTime.now()).getMinute() + ":" + (LocalDateTime.now()).getSecond();

        System.out.println("\033[31m[\033[37m" + time + "\033[31m]" + " \033[31m" + msg);
        writeLog(msg, time);
    }
    /**
     * {@code Logger().info(String msg)} gets a message wich is printed out as a warning
     * @param msg The input message
     */
    public void warning(String msg) {
        String time = (LocalDateTime.now()).getHour() + ":" + (LocalDateTime.now()).getMinute() + ":" + (LocalDateTime.now()).getSecond();

        System.out.println("\033[33m[\033[37m" + time + "\033[33m]" + " \033[33m" + msg);
        writeLog(msg, time);
    }

    /**
     * {@code writeLog()} writes the log into the log.txt file
     * @param msg The log message
     * @param time The time the log gets written
     */
    private void writeLog(String msg, String time) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true))) {
            bw.write("[" + time + "] " + msg +"\n");
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}

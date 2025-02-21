package gigafrosxh.project.util;

import java.time.LocalDateTime;

public class Logger {

    public Logger() {
        String time = (LocalDateTime.now()).getHour() + ":" + (LocalDateTime.now()).getMinute() + ":" + (LocalDateTime.now()).getSecond();

        System.out.println("[\033[34m" + time + "\033[32m]" + " \033[34mLogger call action at " + Thread.currentThread().getName());
    }

    public void info(String msg) {
        String time = (LocalDateTime.now()).getHour() + ":" + (LocalDateTime.now()).getMinute() + ":" + (LocalDateTime.now()).getSecond();

        System.out.println("\033[32m[\033[34m" + time + "\033[32m]" + " \033[34m" + msg);
    }

    public void error(String msg) {
        String time = (LocalDateTime.now()).getHour() + ":" + (LocalDateTime.now()).getMinute() + ":" + (LocalDateTime.now()).getSecond();

        System.out.println("\033[31m[\033[37m" + time + "\033[31m]" + " \033[31m" + msg);
    }

    public void warning(String msg) {
        String time = (LocalDateTime.now()).getHour() + ":" + (LocalDateTime.now()).getMinute() + ":" + (LocalDateTime.now()).getSecond();

        System.out.println("\033[33m[\033[37m" + time + "\033[33m]" + " \033[33m" + msg);
    }
}

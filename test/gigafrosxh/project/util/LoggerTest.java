package gigafrosxh.project.util;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {
    private static final String time = (LocalDateTime.now()).getHour() + ":" + (LocalDateTime.now()).getMinute() + ":" + (LocalDateTime.now()).getSecond();

    @Test
    void info() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        String msg = "INFO";

        System.setOut(printStream);

        Logger logger = new Logger();
        logger.info(msg);

        String result = outputStream.toString();
        String expected = "\033[32m" + "[" + "\033[34m" + time + "\033[32m" + "]" + " \033[34m" + msg + "\r\n";

        assertEquals(expected, result);

    }

    @Test
    void error() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        String msg = "ERROR";

        System.setOut(printStream);

        Logger logger = new Logger();
        logger.error(msg);

        String result = outputStream.toString();
        String expected = "\033[31m" + "[" + "\033[37m" + time + "\033[31m" + "]" + " \033[31m" + msg + "\r\n";

        assertEquals(expected, result);
    }

    @Test
    void warning() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        String msg = "WARNING";

        System.setOut(printStream);

        Logger logger = new Logger();
        logger.warning(msg);

        String result = outputStream.toString();
        String expected = "\033[33m" + "[" + "\033[37m" + time + "\033[33m" + "]" + " \033[33m" + msg + "\r\n";

        assertEquals(expected, result);
    }
}
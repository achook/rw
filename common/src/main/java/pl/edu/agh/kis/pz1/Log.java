package pl.edu.agh.kis.pz1;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Log {

    public static class LogFormatter extends Formatter {

        @Override
        public String format(LogRecord lr) {

            return lr.getMessage();
        }
    }
    protected Logger logger;

    public Log() {
        logger = Logger.getLogger(Thread.currentThread().getName());
        logger.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();

        Formatter formatter = new LogFormatter();
        handler.setFormatter(formatter);

        logger.addHandler(handler);
    }

    public void log(String message) {
        logger.info(message);
    }

    public void logln(String message) {
        log(message + "\n");
    }
}

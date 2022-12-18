package pl.edu.agh.kis.pz1;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Log {

    public static class LogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            String s = record.getMessage();

            Object[] params = record.getParameters();

            return s;
        }
    }
    protected static Logger logger;

    public Log() {
        logger = Logger.getLogger(getClass().getName());
        logger.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();

        Formatter formatter = new LogFormatter();
        handler.setFormatter(formatter);

        logger.addHandler(handler);
    }

    public static void log(String message) {
        logger.info(message);
    }

    public static void logln(String message) {
        log(message + "\n");
    }
}

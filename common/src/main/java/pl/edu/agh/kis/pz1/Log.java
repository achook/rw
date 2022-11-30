package pl.edu.agh.kis.pz1;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Log {

    public static class LogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            // This example will print date/time, class, and log level in yellow,
            // followed by the log message and it's parameters in white .

            String s = record.getMessage();

            Object[] params = record.getParameters();

            return s;
        }
    }
    protected Logger logger;

    public Log() {
        logger = Logger.getLogger(getClass().getName());
        logger.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();

        Formatter formatter = new LogFormatter();
        handler.setFormatter(formatter);

        logger.addHandler(handler);
    }

    protected void log(String message) {
        logger.info(message);
    }

    protected void logln(String message) {
        log(message + "\n");
    }
}

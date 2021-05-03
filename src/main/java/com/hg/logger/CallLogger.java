package com.hg.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallLogger {

    private ErrorLogger errorLog = ErrorLogger.getErrorLogger();
    private Logger log = LoggerFactory.getLogger(CallLogger.class);

    private static CallLogger instance;

    public static CallLogger getCallLogger() {

        if (instance == null) {
            instance = new CallLogger();
        }

        return instance;
    }

    public void trace(String msg) {
        log.trace(msg);
    }

    public void trace(String format, Object arg) {
        log.trace(format, arg);
    }

    public void trace(String format, Object arg1, Object arg2) {
        log.trace(format, arg1, arg2);
    }

    public void trace(String format, Object... arguments) {
        log.trace(format, arguments);
    }

    public void trace(String msg, Throwable t) {
        log.trace(msg, t);
    }

    public void debug(String msg) {
        log.debug(msg);
    }

    public void debug(String format, Object arg) {
        log.debug(format, arg);
    }

    public void debug(String format, Object arg1, Object arg2) {
        log.debug(format, arg1, arg2);
    }

    public void debug(String format, Object... arguments) {
        log.debug(format, arguments);
    }

    public void debug(String msg, Throwable t) {
        log.debug(msg, t);
    }

    public void info(String msg) {
        log.info(msg);
    }

    public void info(String format, Object arg) {
        log.info(format, arg);
    }

    public void info(String format, Object arg1, Object arg2) {
        log.info(format, arg1, arg2);
    }

    public void info(String format, Object... arguments) {
        log.info(format, arguments);
    }

    public void info(String msg, Throwable t) {
        log.info(msg, t);
    }

    public void warn(String msg) {
        log.warn(msg);
    }

    public void warn(String format, Object arg) {
        log.warn(format, arg);
    }

    public void warn(String format, Object... arguments) {
        log.warn(format, arguments);
    }

    public void warn(String format, Object arg1, Object arg2) {
        log.warn(format, arg1, arg2);
    }

    public void warn(String msg, Throwable t) {
        log.warn(msg, t);
    }

    public void error(String msg) {
        log.error(msg);
        errorLog.error(msg);
    }

    public void error(String format, Object arg) {
        log.error(format, arg);
        errorLog.error(format, arg);
    }

    public void error(String format, Object arg1, Object arg2) {
        log.error(format, arg1, arg2);
        errorLog.error(format, arg1, arg2);
    }

    public void error(String format, Object... arguments) {
        log.error(format, arguments);
        errorLog.error(format, arguments);
    }

    public void error(String msg, Throwable t) {
        log.error(msg, t);
        errorLog.error(msg, t);
    }

}

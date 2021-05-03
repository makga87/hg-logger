package com.hg.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorLogger {

	private Logger log = LoggerFactory.getLogger(ErrorLogger.class);

	private static ErrorLogger instance;

	public static ErrorLogger getErrorLogger() {
		if(instance == null){
			instance = new ErrorLogger();
		}
		return instance;
	}
	public void error(String msg) {
		log.error(msg);
	}

	public void error(String format, Object arg) {
		log.error(format, arg);
	}

	public void error(String format, Object arg1, Object arg2) {
		log.error(format, arg1, arg2);
	}

	public void error(String format, Object... arguments) {
		log.error(format, arguments);
	}

	public void error(String msg, Throwable t) {
		log.error(msg, t);
	}
}

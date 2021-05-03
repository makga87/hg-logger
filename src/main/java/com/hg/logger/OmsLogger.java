package com.hg.logger;


import com.hg.logger.context.HGLoggerContext;
import com.hg.logger.obj.abst.AbstractOmsObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OmsLogger {

    private final Logger log = LoggerFactory.getLogger(OmsLogger.class);

    private static OmsLogger instance = new OmsLogger();

    public static OmsLogger getOmsLogger() {
        if (instance == null) {
            instance = new OmsLogger();
        }
        return instance;
    }

    public void write(AbstractOmsObject oms) {
        log.info("{}", oms.toLog());
    }

    public void write() {
        log.info("{}", HGLoggerContext.getOmsLog().toLog());
    }
}

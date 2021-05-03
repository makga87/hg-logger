package com.hg.logger.context;

import com.hg.logger.attribute.LoggerAttributes;
import com.hg.logger.obj.abst.AbstractCallLogObject;
import com.hg.logger.obj.abst.AbstractOmsObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HGLoggerContext {

    private static Logger log = LoggerFactory.getLogger(HGLoggerContext.class);

    private HGLoggerContext() {
    }

    private static final ThreadLocal<LoggerAttributes> loggerAttributes = new ThreadLocal<LoggerAttributes>();

    private static final InheritableThreadLocal<LoggerAttributes> inHeritableLoggerAttributes = new InheritableThreadLocal<LoggerAttributes>();

    public static void applyLogObject(AbstractCallLogObject call, AbstractOmsObject oms) {
        applyLogObject(call, oms, false);
    }

    public static void applyLogObject(AbstractCallLogObject call, AbstractOmsObject oms, boolean inheritable) {

        log.debug("= applyLogObject inheritable {}", inheritable);

        if (inheritable) {
            loggerAttributes.remove();
            if (inHeritableLoggerAttributes.get() == null) {
                LoggerAttributes attributes = new LoggerAttributes(call, oms);
                inHeritableLoggerAttributes.set(attributes);
            } else {
                LoggerAttributes attr = inHeritableLoggerAttributes.get();
                attr.setLogObj(call, oms);
            }

            log.debug("= inHeritableLoggerAttributes.inHeritableLoggerAttributes.get() is {}", inHeritableLoggerAttributes.get());

        } else {
            inHeritableLoggerAttributes.remove();
            if (loggerAttributes.get() == null) {
                LoggerAttributes attributes = new LoggerAttributes(call, oms);
                loggerAttributes.set(attributes);
            } else {
                LoggerAttributes attr = loggerAttributes.get();
                attr.setLogObj(call, oms);
            }

            log.debug("= loggerAttributes.loggerAttributes.get() is {}", loggerAttributes.get());
        }
    }

    public static LoggerAttributes getAttributes() {

        LoggerAttributes attributes = loggerAttributes.get();

        if (attributes == null || (attributes.getCall() == null && attributes.getOms() == null)) {
            log.debug("= Get inheritableLoggerAttributes, {}", inHeritableLoggerAttributes.get());
            return inHeritableLoggerAttributes.get();
        }
        log.debug("= Get loggerAttributes, {}", attributes);
        return attributes;
    }

    public static void setAttributes(LoggerAttributes attributes) {
        setAttributes(attributes, false);
    }

    public static void setAttributes(LoggerAttributes attributes, boolean inheritable) {
        if (attributes == null) {
            resetAttributes();
        } else {
            if (inheritable) {
                inHeritableLoggerAttributes.set(attributes);
                loggerAttributes.remove();
            } else {
                loggerAttributes.set(attributes);
                inHeritableLoggerAttributes.remove();
            }
        }
    }

    public static void resetAttributes() {
        log.debug("= Reset log attributes");
        loggerAttributes.remove();
        inHeritableLoggerAttributes.remove();
    }

    public static AbstractCallLogObject getCallLog() {

        AbstractCallLogObject call = null;

        if (loggerAttributes.get() == null || loggerAttributes.get().getCall() == null) {
            call = inHeritableLoggerAttributes.get().getCall();
            log.debug("= Get InheritableLoggerAttributes.call, {}", call);
            return call;
        }

        call = loggerAttributes.get().getCall();
        log.debug("= Get loggerAttribute.call, {}", call);
        return call;
    }

    public static AbstractOmsObject getOmsLog() {

        AbstractOmsObject oms = null;

        if (loggerAttributes.get() == null || loggerAttributes.get().getOms() == null) {
            oms = inHeritableLoggerAttributes.get().getOms();
            log.debug("= Get inheritableLoggerAttributes.oms, {}", oms);
            return oms;
        }

        oms = loggerAttributes.get().getOms();
        log.debug("= Get loggerAttributes.oms, {}", oms);
        return oms;
    }

}

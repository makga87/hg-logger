package com.hg.logger.layout;

import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import ch.qos.logback.core.util.CachingDateFormatter;
import com.hg.logger.context.HGLoggerContext;
import com.hg.logger.obj.abst.AbstractCallLogObject;

public class CallLogLayout extends LayoutBase<ILoggingEvent> {

	CachingDateFormatter cachingDateFormatter = new CachingDateFormatter("yyyyMMdd HH:mm:ss.SSS");
	ThrowableProxyConverter tpc = new ThrowableProxyConverter();

	@Override
	public void start() {
		tpc.start();
		super.start();
	}

	public String doLayout(ILoggingEvent event) {
		
		AbstractCallLogObject call = HGLoggerContext.getCallLog();
		
		if (!isStarted()) {
			return CoreConstants.EMPTY_STRING;
		}
		
		StringBuilder sb = new StringBuilder();
		
		long timestamp = event.getTimeStamp();
		sb.append("[").append(cachingDateFormatter.format(timestamp)).append("]");
		sb.append("[").append(event.getLevel()).append("]");
		if(call != null) {
			sb.append(call.toLog());
		}
		sb.append(event.getFormattedMessage());
		sb.append(CoreConstants.LINE_SEPARATOR);
		IThrowableProxy tp = event.getThrowableProxy();
		if (tp != null) {
			String stackTrace = tpc.convert(event);
			sb.append(stackTrace);
		}

		return sb.toString();
	}

}

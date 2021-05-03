package com.hg.logger.layout;

import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import com.hg.logger.context.HGLoggerContext;
import com.hg.logger.obj.abst.AbstractOmsObject;

public class OmsLogLayout extends LayoutBase<ILoggingEvent> {
	
	ThrowableProxyConverter tpc = new ThrowableProxyConverter();

	@Override
	public void start() {
		tpc.start();
		super.start();
	}
	
	public String doLayout(ILoggingEvent event) {
		
		AbstractOmsObject oms = HGLoggerContext.getOmsLog();
		if (!isStarted()) {
			return CoreConstants.EMPTY_STRING;
		}
		
		StringBuilder sb = new StringBuilder();
		if(oms != null) {
			sb.append(oms.toLog());
		}
		sb.append(CoreConstants.LINE_SEPARATOR);
		IThrowableProxy tp = event.getThrowableProxy();
		if (tp != null) {
			String stackTrace = tpc.convert(event);
			sb.append(stackTrace);
		}
		
		return sb.toString();
	}

	
}

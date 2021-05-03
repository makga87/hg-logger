package com.hg.logger.attribute;

import com.hg.logger.obj.abst.AbstractCallLogObject;
import com.hg.logger.obj.abst.AbstractOmsObject;

public class LoggerAttributes {
	
	private AbstractCallLogObject call;
	private AbstractOmsObject oms;
	
	public LoggerAttributes() {
	}
	
	public LoggerAttributes(AbstractCallLogObject call, AbstractOmsObject oms) {
		this.call = call;
		this.oms = oms;
	}

	public AbstractCallLogObject getCall() {
		return call;
	}

	public AbstractOmsObject getOms() {
		return oms;
	}

	public void setCall(AbstractCallLogObject call) {
		this.call = call;
	}

	public void setOms(AbstractOmsObject oms) {
		this.oms = oms;
	}
	
	public void setLogObj(AbstractCallLogObject call, AbstractOmsObject oms) {
		this.call = call;
		this.oms = oms;
	}
}

package com.hg.logger.obj.abst;

/**
 * 로그 추상 객체
 * 로그용 객체를 만들 때는, 해당 객체를 extends하여 개발한다.
 * @author khg
 *
 */
public abstract class AbstractCallLogObject {
	
	public abstract int objId();
	public abstract String toLog();
	public abstract AbstractCallLogObject cloneObj() throws CloneNotSupportedException;
	
}

package com.qfedu.bz;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.common.WoException;
import com.qfedu.common.entity.WoResultCode;

public class BzException extends WoException {
	private final static Logger LOG = LogManager.getLogger(BzException.class);
	
	public BzException() {
	}

	public BzException(WoResultCode code, Object... args) {
		super(code, args);
	}

	public BzException(Throwable cause, WoResultCode code, Object... args) {
		super(cause, code, args);
	}
}

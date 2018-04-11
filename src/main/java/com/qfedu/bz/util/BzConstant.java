package com.qfedu.bz.util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.common.entity.WoResultCode;

public class BzConstant {
	
	private final static Logger LOG = LogManager.getLogger(BzConstant.class);
	
	public final static WoResultCode ERR_STAFF = new WoResultCode (1000, "该用户未关联人员！");
}

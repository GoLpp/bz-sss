package com.qfedu.bz.controller;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qfedu.common.entity.WoResultCode;
import com.zhu.pojo.Man;
@RestController
@RequestMapping(value="/sys/post")

public class HttpClentTestController {
	private final static Logger LOG = LogManager.getLogger(HttpClentTestController.class);
	
	@RequestMapping(value="/test")
	public WoResultCode test(@RequestBody List<Man> mans) {
		LOG.info(mans);
		return WoResultCode.getSuccessCode();
	}
}

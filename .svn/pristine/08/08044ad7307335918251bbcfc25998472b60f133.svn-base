package com.qfedu.bz.controller;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qfedu.bz.dto.VqDto;
import com.qfedu.bz.service.IVqService;
import com.qfedu.common.entity.WoResultCode;

@RestController
@RequestMapping("/bz/vq")
public class VQController {
	private final static Logger LOG = LogManager.getLogger(VQController.class);
	
	@Resource
	private IVqService vqService;
	
	@RequestMapping("/create")
	public WoResultCode create (@RequestBody List<VqDto> list) {
		LOG.info(list);
		vqService.createList(list);
		return WoResultCode.getSuccessCode();
	}
	
	@RequestMapping("/create2")
	public WoResultCode create2 (@RequestBody VqDto vq) {
		LOG.info(vq);
		vqService.create(vq);
		return WoResultCode.getSuccessCode();
	}
	
	@RequestMapping("/create3")
	public WoResultCode create3 (VqDto vq) {
		LOG.info(vq);
		vqService.create(vq);
		return WoResultCode.getSuccessCode();
	}
}

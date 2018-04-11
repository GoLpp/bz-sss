package com.qfedu.bz.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qfedu.bz.dao.IVqDao;
import com.qfedu.bz.dto.VqDto;
import com.qfedu.bz.service.IVqService;

@Service
public class VqService implements IVqService {
	private final static Logger LOG = LogManager.getLogger(VqService.class);

	@Resource
	private IVqDao vqDao;
	
	@Override
	public void create(VqDto vq) {
		vqDao.save(vq.createEntity());
	}

	@Override
	public void createList(List<VqDto> vqs) {
		for (VqDto dto : vqs) {
			create(dto);
		}
	}
}

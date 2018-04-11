package com.qfedu.esys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.qfedu.common.entity.WoPage;
import com.qfedu.common.util.WoUtil;
import com.qfedu.esys.dao.IDictionaryDao;
import com.qfedu.esys.dto.DictionaryDto;
import com.qfedu.esys.entity.Dictionary;
import com.qfedu.esys.service.IDictionaryService;

@Service
@Transactional
public class DictionaryService implements IDictionaryService {
	private final static Logger LOG = LogManager.getLogger(DictionaryService.class);

	@Resource
	private IDictionaryDao dictionaryDao;

	@Override
	public WoPage<Dictionary> getGridData(String dicType, Long page, Long size) {
		// 设置分页参数，查询条件返回结果集
		Page<Dictionary> result = null;
		Pageable p = PageRequest.of(page.intValue(), size.intValue(), Direction.ASC, "dicType");
		if (WoUtil.isEmpty(dicType)) {
			result = dictionaryDao.findAll(p);
		} else {
			result = dictionaryDao.findAllByDicTypeLike(dicType, p);
		}
		// 将查询结果转化为要求的数据
		WoPage<Dictionary> data = new WoPage<Dictionary>();
		data.setResults(result.getTotalElements());
		data.setRows(result.getContent());
		return data;
	}

	@Override
	public void create(Dictionary dic) {
		dictionaryDao.save(dic);
	}

	@Override
	public void update(Dictionary dic) {
		Dictionary dic2 = dictionaryDao.findById(dic.getId()).get();
		// 测试乐观锁
//		if (dic.getDescription().equals("nv1")) {
//			try {
//				LOG.info("sleep-start:" + dic.getDescription());
//				Thread.sleep(3000);
//				LOG.info("sleep-end:" + dic.getDescription());
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		dic2.setDescription(dic.getDescription());
		dic2.setDicType(dic.getDicType());
		dic2.setName(dic.getName());
		dic2.setVal(dic.getVal());
		dictionaryDao.save(dic2);
	}

	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			dictionaryDao.deleteById(id);
		}
	}

	@Override
	public List<Dictionary> getByType(String dicType) {
		return dictionaryDao.findAllByDicType(dicType);
	}

}

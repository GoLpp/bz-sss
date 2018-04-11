package com.qfedu.bz.test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.esys.entity.Dictionary;
import com.qfedu.esys.entity.Menu;
import com.qfedu.esys.entity.Role;
import com.qfedu.esys.entity.User;
import com.qfedu.esys.service.IDictionaryService;
import com.qfedu.esys.service.IUserExtensionService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示整合JUnit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) // 加载spring配置文件
public class TestBz {

	@Resource
	private IUserExtensionService userExService;

	private final static Logger LOG = LogManager.getLogger(TestBz.class);

	@Test
	@Transactional
	@Rollback
	public void test00() {
		LOG.info(userExService.getClass());
	}
	
}

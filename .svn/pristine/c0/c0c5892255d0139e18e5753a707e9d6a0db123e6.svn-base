package com.qfedu.bz.test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.bz.dto.LeaveDto;
import com.qfedu.bz.service.ILeaveService;
import com.qfedu.esys.dto.UserDto;

@RunWith(SpringJUnit4ClassRunner.class) // 表示整合JUnit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) // 加载spring配置文件
public class TestLeave {

	@Resource
	private ILeaveService leaveService;

	private final static Logger LOG = LogManager.getLogger(TestLeave.class);

	@Test
	@Transactional
	@Rollback(false)
	public void test00() {
		UserDto u = new UserDto ();
		u.setId("8a873a08628a9b2101628ab3cfbc0003");
		LeaveDto l = new LeaveDto ();
		l.setReason("家有喜事，请假三天");
		leaveService.apply(u, l);
	}
	
}

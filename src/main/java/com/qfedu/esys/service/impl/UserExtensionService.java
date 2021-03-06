package com.qfedu.esys.service.impl;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qfedu.esys.ESysException;
import com.qfedu.esys.dao.IDictionaryDao;
import com.qfedu.esys.dao.IStaffDeptRelationDao;
import com.qfedu.esys.dto.UserDto;
import com.qfedu.esys.entity.StaffDeptRelation;
import com.qfedu.esys.service.IUserExtensionService;
import com.qfedu.esys.util.ESysConstant;

@Service
@Transactional
public class UserExtensionService implements IUserExtensionService {
	private final static Logger LOG = LogManager.getLogger(UserExtensionService.class);

	@Resource
	private IStaffDeptRelationDao staffDeptRelationDao;
	
	@Resource
	private IDictionaryDao dictionaryDao;
	
	@Override
	public void setUserInfo(UserDto u) {
		if (u.isAdmin()) {
			u.setStaffNames("系统管理员");
			u.setStaffDeptNames("不属于任何部门");
			return;
		}
		List<StaffDeptRelation> relations = staffDeptRelationDao.findAllByStaffUserId(u.getId());
		if (relations.size() == 0) {
			throw new ESysException (ESysConstant.ERR_LOGIN_DEPT);
		}
		StaffDeptRelation r = relations.get(0);
		u.setDeptIds(r.getDept().getId());
		u.setDeptNames(r.getDept().getName());
		u.setStaffIds(r.getStaff().getId());
		u.setStaffNames(r.getStaff().getName());
		u.setStaffDeptIds(r.getId());
		String positionName = dictionaryDao.findByDicTypeAndVal("position", r.getPosition()).getName();
		// 设置人员部门名字为：部门名字-职务名称
		u.setStaffDeptNames(u.getDeptNames() + "-" + positionName);
	}
}

package com.qfedu.esys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qfedu.common.entity.WoPage;
import com.qfedu.common.util.WoUtil;
import com.qfedu.esys.dao.IRoleDao;
import com.qfedu.esys.dto.RoleDto;
import com.qfedu.esys.entity.Menu;
import com.qfedu.esys.entity.Role;
import com.qfedu.esys.service.IRoleService;

@Service
@Transactional
public class RoleService implements IRoleService {
	private final static Logger LOG = LogManager.getLogger(RoleService.class);

	@Resource // @Autowired
	private IRoleDao roleDao;

	@Override
	public WoPage<RoleDto> getGridData(String name, Long page, Long size) {
		// 从dao获取数据
		Pageable pageInput = PageRequest.of(page.intValue() - 1, size.intValue());
		Page<Role> pageData = null;
		if (WoUtil.isEmpty(name)) {
			pageData = roleDao.findAll(pageInput);
		} else {
			pageData = roleDao.findAllByNameLike ("%" + name + "%", pageInput);
		}
		// 将Role转化为RoleDto
		WoPage<RoleDto> pr = RoleDto.getGridData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}

	@Override
	public void create(RoleDto dto) {
		// 设置简单属性，创建PO
		Role r = dto.createEntity();
		// PO入库
		roleDao.save(r);
	}

	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			roleDao.deleteById(id);
		}
	}

	@Override
	public void update(RoleDto dto) {
		Role r = roleDao.findById(dto.getId()).get();
		r.setName(dto.getName());
		r.setDescription(dto.getDescription());
		r.setType(dto.getType());
		List<Menu> menus = new ArrayList<Menu>();
		for (String mId : dto.getMenuIdArray()) {
			Menu m = new Menu();
			m.setId(mId);
			menus.add(m);
		}
		r.setMenus(menus);
		roleDao.save(r);
	}

}

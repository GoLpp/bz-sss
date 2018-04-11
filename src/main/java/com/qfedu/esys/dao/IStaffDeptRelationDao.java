package com.qfedu.esys.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qfedu.esys.entity.StaffDeptRelation;

public interface IStaffDeptRelationDao extends CrudRepository<StaffDeptRelation, String> {
	List<StaffDeptRelation> findAllByStaffUserId (String userId);
}

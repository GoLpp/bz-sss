package com.qfedu.esys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.qfedu.esys.entity.Role;

/**
 * @author cailei
 */
public interface IRoleDao extends PagingAndSortingRepository<Role, String>{
	
	Page<Role> findAllByNameLike (String name, Pageable p);
	
}
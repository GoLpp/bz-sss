package com.qfedu.esys.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.qfedu.esys.entity.User;

public interface IUserDao extends PagingAndSortingRepository<User, String>{

	User findByLoginName(String user);

	Page<User> findAllByLoginNameLike (String loginName, Pageable p);

}

package com.qfedu.esys.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qfedu.esys.entity.Menu;

/**
 * @author cailei
 */
public interface IMenuDao extends CrudRepository<Menu, String> {

	List<Menu> findAllByParentIdIsNull ();

	List<Menu> findAllByParentId(String parentId);

}
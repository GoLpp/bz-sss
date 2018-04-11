package com.qfedu.esys.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.qfedu.esys.entity.Dictionary;

/**
 * @author cailei
 */
public interface IDictionaryDao extends PagingAndSortingRepository<Dictionary, String> {

	Page<Dictionary> findAllByDicTypeLike (String dicType, Pageable p);
	
	/**
	 * 根据数据字典类型，查询数据字典列表
	 * @param dicType
	 * @return
	 */
	List<Dictionary> findAllByDicType (String dicType);
	
	/**
	 * 根据数据字典类型和值，查询数据字典
	 * @param dicType
	 * @param val
	 * @return
	 */
	Dictionary findByDicTypeAndVal (String dicType, String val);
}
package com.qfedu.bz.service;
import java.io.InputStream;

import com.qfedu.bz.dto.LeaveDto;
import com.qfedu.common.entity.WoPage;
import com.qfedu.esys.dto.UserDto;

public interface ILeaveService {

	/**
	 * 待我处理
	 * @param u
	 * @param searchContent
	 * @param page
	 * @param rows
	 * @return
	 */
	WoPage<LeaveDto> getListFor(UserDto u, String searchContent, Long page, Long rows);

	/**
	 * 与我相关
	 * @param u
	 * @param searchContent
	 * @param page
	 * @param rows
	 * @return
	 */
	WoPage<LeaveDto> getListOf(UserDto u, String searchContent, Long page, Long rows);
	
	/**
	 * 所有
	 * @param u
	 * @param searchContent
	 * @param page
	 * @param rows
	 * @return
	 */
	WoPage<LeaveDto> getList (UserDto u, String searchContent, Long page, Long rows);
	
	/**
	 * 申请，包括打回之后重新申请
	 * @param u
	 * @param l
	 */
	void apply (UserDto u, LeaveDto l);
	
	/**
	 * 审批
	 * @param u
	 * @param l
	 */
	void review (UserDto u, LeaveDto l);
	
	/**
	 * 获取流程图输入流
	 * @param id
	 * @return
	 */
	public InputStream getDiagram(String id);
}

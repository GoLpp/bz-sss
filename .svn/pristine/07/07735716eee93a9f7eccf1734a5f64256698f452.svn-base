package com.qfedu.bz.controller;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qfedu.bz.dto.LeaveDto;
import com.qfedu.bz.service.ILeaveService;
import com.qfedu.common.entity.WoPage;
import com.qfedu.common.entity.WoResultCode;
import com.qfedu.esys.dto.UserDto;
import com.qfedu.esys.util.ESysConstant;
import com.qfedu.esys.vo.GridEuiVo;

@RestController
@RequestMapping("bz/leave")
@SessionAttributes(names = ESysConstant.SESSION_USER)
public class LeaveController {
	private final static Logger LOG = LogManager.getLogger(LeaveController.class);
	
	@Resource
	private ILeaveService leaveService;
	
	/**
	 * 待我处理
	 * @param map
	 * @param searchContent
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/listFor")
	public GridEuiVo<LeaveDto> getListFor(Map<String, Object> map, String searchContent, Long page, Long rows) {
		UserDto u = (UserDto)map.get(ESysConstant.SESSION_USER);
		WoPage<LeaveDto> dto = leaveService.getListFor(u, searchContent, page, rows);
		return new GridEuiVo<LeaveDto>(dto);
	}
	
	/**
	 * 与我相关
	 * @param map
	 * @param searchContent
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/listOf")
	public GridEuiVo<LeaveDto> getListOf(Map<String, Object> map, String searchContent, Long page, Long rows) {
		UserDto u = (UserDto)map.get(ESysConstant.SESSION_USER);
		WoPage<LeaveDto> dto = leaveService.getListOf(u, searchContent, page, rows);
		return new GridEuiVo<LeaveDto>(dto);
	}
	
	/**
	 * 所有
	 * @param map
	 * @param searchContent
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	public GridEuiVo<LeaveDto> getList(Map<String, Object> map, String searchContent, Long page, Long rows) {
		UserDto u = (UserDto)map.get(ESysConstant.SESSION_USER);
		WoPage<LeaveDto> dto = leaveService.getList(u, searchContent, page, rows);
		return new GridEuiVo<LeaveDto>(dto);
	}
	
	@RequestMapping("/apply")
	public WoResultCode apply (Map<String, Object> map, LeaveDto l) {
		UserDto u = (UserDto)map.get(ESysConstant.SESSION_USER);
		leaveService.apply(u, l);
		return WoResultCode.getSuccessCode();
	}
	
	@RequestMapping("/review")
	public WoResultCode review (Map<String, Object> map, LeaveDto l) {
		UserDto u = (UserDto)map.get(ESysConstant.SESSION_USER);
		leaveService.review(u, l);
		return WoResultCode.getSuccessCode();
	}
	
	@RequestMapping("/diagram")
	public void showDiagram (String id, HttpServletResponse response) throws IOException {
		InputStream in = leaveService.getDiagram (id);
		// https://www.cnblogs.com/cxyj/p/3891424.html
		// http://blog.csdn.net/xc137647341/article/details/77340937
		FileCopyUtils.copy(in, response.getOutputStream());
	}
}

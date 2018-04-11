package com.qfedu.bz.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qfedu.bz.entity.Watch;
import com.qfedu.common.util.WoConstant;
public class WatchDto {
	private final static Logger LOG = LogManager.getLogger(WatchDto.class);

    private String id;

    private String detail;

    private String name;

    private String no;

    private String parameters;

    private Date userTime;

    private String departmentId;
    
    private String departmentName;

    private String staffId;
    
    private String staffName;

    public WatchDto(Watch watch) {
    	this.id = watch.getId();
    	this.name = watch.getName();
    	this.detail = watch.getDetail();
    	this.no = watch.getNo();
    	this.userTime = watch.getUserTime();
    	this.departmentId = watch.getDepartment().getId();
    	this.departmentName = watch.getDepartment().getName();
    	this.staffId = watch.getStaff().getId();
    	this.staffName = watch.getStaff().getName();
    }
    
    public static List<WatchDto> getDtos(List<Watch> list) {
    	List<WatchDto> dtos = new ArrayList<>();
    	for(Watch w : list) {
    		dtos.add(new WatchDto(w));
    	}
    	return dtos;
    }
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	@JsonFormat(pattern = WoConstant.FORMAT_DATETIME, locale = "zh", timezone = "GMT+8")
	public Date getUserTime() {
		return userTime;
	}

	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
}

package com.qfedu.bz.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.bz.entity.Gateway;
import com.qfedu.esys.entity.Dept;
import com.qfedu.esys.entity.Staff;

public class GatewayDto {

	private final static Logger LOG = LogManager.getLogger(GatewayDto.class);

	private String id;

	private String name;

	private String no;

	private String parameters;

	private String detail;

	private Date  userTime;

	private Staff staff;

	private Dept department;

	public GatewayDto(Gateway gateway) {
		id=gateway.getId();
		name=gateway.getName();
		no=gateway.getNo();
		parameters=gateway.getParameters();
		detail=gateway.getDetail();
		userTime=gateway.getUserTime();
		staff=gateway.getStaff();
		department=gateway.getDepartment();
	}

	public static  List<GatewayDto> getDtos(List<Gateway> ps){
		List<GatewayDto> dtos=new ArrayList<GatewayDto>();
		for (Gateway p : ps) {
			dtos.add(new GatewayDto(p));
		}
		return dtos;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getUserTime() {
		return userTime;
	}

	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Dept getDepartment() {
		return department;
	}

	public void setDepartment(Dept department) {
		this.department = department;
	}

}

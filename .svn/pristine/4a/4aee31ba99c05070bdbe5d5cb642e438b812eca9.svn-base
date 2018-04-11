package com.qfedu.bz.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.bz.entity.Pressure;

public class PressureDto {

	private final static Logger LOG = LogManager.getLogger(Pressure.class);

	private String id;

	private Date collectedTime;

	private String collectedValue;

	private String staffId;

	private String taskId;

	private String gatewayId;

	private String watchId;
	
	private String staffName;

	private String taskTitle;

	private String gatewayName;

	private String watchName;

	public PressureDto() {
	}

	public PressureDto(Pressure p) {
		this.id = p.getId();
		this.collectedTime = p.getCollectedTime();
		this.collectedValue = p.getCollectedValue();
		if (p.getStaff() != null) {
			this.staffId = p.getStaff().getId();
			this.staffName = p.getStaff().getName();
		}
		if (p.getTask() != null) {
			this.taskId = p.getTask().getId();
			this.taskTitle = p.getTask().getTitle();
		}
		if (p.getGateway() != null) {
			this.gatewayId = p.getGateway().getId();
			this.gatewayName = p.getGateway().getName();
		}
		if (p.getWatch() != null) {
			this.watchId = p.getWatch().getId();
			this.watchName = p.getWatch().getName();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCollectedTime() {
		return collectedTime;
	}

	public void setCollectedTime(Date collectedTime) {
		this.collectedTime = collectedTime;
	}

	public String getCollectedValue() {
		return collectedValue;
	}

	public void setCollectedValue(String collectedValue) {
		this.collectedValue = collectedValue;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getWatchId() {
		return watchId;
	}

	public void setWatchId(String watchId) {
		this.watchId = watchId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public String getWatchName() {
		return watchName;
	}

	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}

	public static List<PressureDto> getDtos(List<Pressure> ps) {
		List<PressureDto> dtos = new ArrayList<PressureDto>();
		for (Pressure p : ps) {
			dtos.add(new PressureDto(p));
		}
		return dtos;
	}
}

package com.qfedu.bz.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.bz.entity.Fatigue;


public class FatigueDto {

	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(FatigueDto.class);
	
	private String id;
	
	private Date collectedTime;
	
	private String collectedValue;
	
	private String staffId;
	
	private String staffName;
	
	private String taskId;
	
	private String taskName;
	
	private String gatewayId;
	
	private String gatewayName;
	
	private String watchId;
	
	private String watchName;
	
	public FatigueDto() {
		
	}

	public FatigueDto(Fatigue f) {
		super();
		this.id = f.getId();
		this.collectedTime = f.getCollectedTime();
		this.collectedValue = f.getCollectedValue();
		this.staffId = f.getStaff().getId();
		this.staffName = f.getStaff().getName();
		this.taskId = f.getTask().getId();
		this.taskName = f.getTask().getContent();
		this.gatewayId = f.getGateway().getId();
		this.gatewayName = f.getGateway().getName();
		this.watchId = f.getWatch().getId();
		this.watchName = f.getWatch().getName();
	}

	public static List<FatigueDto> getDtos (List<Fatigue> fs) {
		List<FatigueDto> dtos = new ArrayList<FatigueDto>();
		for (Fatigue f : fs) {
			dtos.add(new FatigueDto(f));
		}
		return dtos;
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

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public String getWatchId() {
		return watchId;
	}

	public void setWatchId(String watchId) {
		this.watchId = watchId;
	}

	public String getWatchName() {
		return watchName;
	}

	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}
	
	
}

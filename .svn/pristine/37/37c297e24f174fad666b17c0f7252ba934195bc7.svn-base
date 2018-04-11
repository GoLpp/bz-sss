package com.qfedu.bz.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qfedu.bz.entity.HeartRate;

public class HeartRateDto {
	private final static Logger LOG = LogManager.getLogger(HeartRateDto.class);
	
	private String id;
	
	private String collectedValue;
	
	@JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
	private Date collectedTime;
	
	private String staffId;
	private String staffName;
	
	private String taskId;
	private String taskName;
	
	private String weargatewayId;
	private String weargatewayName;
	
	private String watchId;
	private String watchName;
	
	public static List<HeartRateDto> getList(List<HeartRate> hrs){
		List<HeartRateDto> dtos = new ArrayList<HeartRateDto>();
		for (HeartRate heartRateDto : hrs) {
			dtos.add(new HeartRateDto(heartRateDto));
		}
		return dtos;
	}

	public HeartRateDto(HeartRate hr) {
		
		
		id = hr.getId();
		collectedValue = hr.getCollectedValue();
		collectedTime = hr.getCollectedTime();
		staffId = hr.getStaff().getId();
		staffName = hr.getStaff().getName();
		taskId = hr.getTask().getId();
		taskName = hr.getTask().getTitle();
		weargatewayId = hr.getTask().getTitle();
		watchId = hr.getWatch().getId();
		watchName = hr.getWatch().getName();
		
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}


	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getWeargatewayName() {
		return weargatewayName;
	}

	public void setWeargatewayName(String weargatewayName) {
		this.weargatewayName = weargatewayName;
	}

	public String getWatchName() {
		return watchName;
	}

	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCollectedValue() {
		return collectedValue;
	}

	public void setCollectedValue(String collectedValue) {
		this.collectedValue = collectedValue;
	}

	public Date getCollectedTime() {
		return collectedTime;
	}

	public void setCollectedTime(Date collectedTime) {
		this.collectedTime = collectedTime;
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

	public String getWeargatewayId() {
		return weargatewayId;
	}

	public void setWeargatewayId(String weargatewayId) {
		this.weargatewayId = weargatewayId;
	}

	public String getWatchId() {
		return watchId;
	}

	public void setWatchId(String watchId) {
		this.watchId = watchId;
	}
	
}

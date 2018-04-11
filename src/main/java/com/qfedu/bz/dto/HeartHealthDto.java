package com.qfedu.bz.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qfedu.bz.entity.HeartHealth;
import com.qfedu.common.util.WoConstant;

public class HeartHealthDto {
	
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(HeartHealthDto.class);
	
	private String id;
	
	private String collectedValue;
	
	private Date collectedTime;
	
	private String staffId;
	
	private String staffName;
	
	private String taskId;
	
	private String taskTitle;
	
	private String gatewayId;
	
	private String gatewayName;
	
	private String watchId;
	
	private String watchName;
	
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

	@JsonFormat(pattern=WoConstant.FORMAT_DATETIME,locale="zh",timezone="GMT+8")
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

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
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

	public HeartHealthDto(){
	}

	public HeartHealthDto(HeartHealth heart){
		this.id = heart.getId();
		this.collectedValue = heart.getCollectedValue();
		this.collectedTime = heart.getCollectedTime();
		if(heart.getStaff()!= null){
			this.staffId = heart.getStaff().getId();
			this.staffName =  heart.getStaff().getName();
		}
		if(heart.getTask()!=null){
			this.taskId = heart.getTask().getId();
			this.taskTitle = heart.getTask().getTitle();
		}
		if(heart.getGateway()!=null){
			this.gatewayId = heart.getGateway().getId();
			this.gatewayName = heart.getGateway().getName();
		}
		if(heart.getWatch()!=null){
			this.watchId = heart.getWatch().getId();
			this.watchName = heart.getWatch().getName();
		}
	}
	
	public static List<HeartHealthDto> getDtos (List<HeartHealth> ps) {
		List<HeartHealthDto> dtos = new ArrayList<HeartHealthDto>();
		for (HeartHealth p : ps) {
			HeartHealthDto dto = new HeartHealthDto(p);
			dtos.add(dto);
		}
		return dtos;
	}
	
	
	
}

package com.qfedu.bz.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qfedu.bz.entity.EnvInfo;
import com.qfedu.common.util.WoConstant;

public class EnvInfoDto {
	private final static Logger LOG = LogManager.getLogger(EnvInfoDto.class);

	private String id;
	
	private Date collectedTime;
	
	private Double humidity;
	
	private Double pressure;
	
	private Double temperature;
	
	private Double ultravioletray;
	
	private String gatewayId;
	
	private String gatewayName;
	
	private String staffId;
	
	private String staffName;
	
	private String taskId;
	
	private String taskTitle;

	public EnvInfoDto() {
		super();
	}
	
	public EnvInfoDto(EnvInfo envInfo){
		id=envInfo.getId();
		collectedTime=envInfo.getCollectedTime();
		humidity=envInfo.getHumidity();
		pressure=envInfo.getPressure();
		temperature=envInfo.getTemperature();
		ultravioletray=envInfo.getUltravioletrays();
		gatewayId=envInfo.getGateway().getId();
		gatewayName=envInfo.getGateway().getName();
		staffId=envInfo.getStaff().getId();
		staffName=envInfo.getStaff().getName();
		taskId=envInfo.getTask().getId();
		taskTitle=envInfo.getTask().getTitle();
	}
	
	public static List<EnvInfoDto> getDtos (List<EnvInfo> ps) {
		List<EnvInfoDto> dtos = new ArrayList<EnvInfoDto>();
		for (EnvInfo p : ps) {
			dtos.add(new EnvInfoDto(p));
		}
		return dtos;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonFormat(pattern=WoConstant.FORMAT_DATETIME,locale="zh",timezone="GMT+8")
	public Date getCollectedTime() {
		return collectedTime;
	}

	public void setCollectedTime(Date collectedTime) {
		this.collectedTime = collectedTime;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getUltravioletray() {
		return ultravioletray;
	}

	public void setUltravioletray(Double ultravioletray) {
		this.ultravioletray = ultravioletray;
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

}

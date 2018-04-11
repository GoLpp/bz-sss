package com.qfedu.bz.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qfedu.bz.entity.GisInfo;
import com.qfedu.common.util.WoConstant;

public class GisInfoDto {
	private final static Logger LOG = LogManager.getLogger(GisInfoDto.class);

	private String id;
	private Double altitude;
	private Date collectedTime;
	private Double latitude;
	private Double longitude;
	private String gatewayId;
	private String gatewayName;
	private String staffId;
	private String staffName;
	private String taskId;
	private String taskTitle;

	public GisInfoDto(GisInfo g) {
		id = g.getId();
		altitude = g.getAltitude();
		collectedTime = g.getCollectedTime();
		latitude = g.getLatitude();
		longitude = g.getLongitude();
		if (g.getGateway() != null) {
			this.gatewayId = g.getGateway().getId();
			this.gatewayName = g.getGateway().getName();
		}
		if (g.getStaff() != null) {
			this.staffId = g.getStaff().getId();
			this.staffName = g.getStaff().getName();
		}
		if (g.getTask() != null) {
			this.taskId = g.getTask().getId();
			this.taskTitle = g.getTask().getTitle();
		}
	}

	public static List<GisInfoDto> getList(List<GisInfo> gis) {
		List<GisInfoDto> gs = new ArrayList<>();
		for (GisInfo c : gis) {
			GisInfoDto dto = new GisInfoDto(c);
			gs.add(dto);
		}
		return gs;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	@JsonFormat(pattern = WoConstant.FORMAT_DATETIME, locale = "zh", timezone="GMT+8")
	public Date getCollectedTime() {
		return collectedTime;
	}

	public void setCollectedTime(Date collectedTime) {
		this.collectedTime = collectedTime;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
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

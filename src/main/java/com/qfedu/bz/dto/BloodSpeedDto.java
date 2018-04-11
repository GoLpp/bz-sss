package com.qfedu.bz.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qfedu.bz.entity.BloodSpeed;
import com.qfedu.common.util.WoConstant;

public class BloodSpeedDto {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(BloodSpeedDto.class);

	/**
	 * id
	 */
	private String id;

	/**
	 * 采集时间
	 */
	private Date collectedTime;

	/**
	 * 采集值
	 */
	private String collectedValue;

	/**
	 * 腕表id
	 */
	private String watchId;

	/**
	 * 腕表名称
	 */
	private String watchName;

	/**
	 * 人员id
	 */
	private String staffId;

	/**
	 * 人员姓名
	 */
	private String staffName;

	/**
	 * 任务id
	 */
	private String taskId;

	/**
	 * 任务标题
	 */
	private String taskTitle;

	/**
	 * 网关id
	 */
	private String gatewayId;

	/**
	 * 网关名称
	 */
	private String gatewayName;

	public BloodSpeedDto() {
	}

	public BloodSpeedDto(BloodSpeed bs) {
		this.id = bs.getId();
		this.collectedTime = bs.getCollectedTime();
		this.collectedValue = bs.getCollectedValue();
		this.watchId = bs.getWatch().getId();
		this.watchName = bs.getWatch().getName();
		this.staffId = bs.getStaff().getId();
		this.staffName = bs.getStaff().getName();
		this.taskId = bs.getTask().getId();
		this.taskTitle = bs.getTask().getTitle();
		this.gatewayId = bs.getGateway().getId();
		this.gatewayName = bs.getGateway().getName();
	}

	public static List<BloodSpeedDto> getDtos(List<BloodSpeed> bs) {
		List<BloodSpeedDto> dtos = new ArrayList<BloodSpeedDto>();
		for (BloodSpeed b : bs) {
			dtos.add(new BloodSpeedDto(b));
		}
		return dtos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonFormat(pattern = WoConstant.FORMAT_DATETIME, locale = "zh", timezone = "GMT+8")
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
}

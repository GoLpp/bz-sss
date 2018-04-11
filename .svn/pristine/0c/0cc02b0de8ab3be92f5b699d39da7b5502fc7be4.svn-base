package com.qfedu.bz.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qfedu.bz.entity.Gateway;
import com.qfedu.bz.entity.Task;
import com.qfedu.bz.entity.Vq;
import com.qfedu.bz.entity.Watch;
import com.qfedu.common.util.WoConstant;
import com.qfedu.common.util.WoUtil;
import com.qfedu.esys.entity.Staff;

public class VqDto {
	
	private final static Logger LOG = LogManager.getLogger(VqDto.class);
	
	private String id;
	
	private Date collectedTime;
	
	private String collectedValue;
	
	private String watchId;
	
	private String watchName;
	
	private String staffId;
	
	private String staffName;
	
	private String taskId;
	
	private String taskName;
	
	private String gatewayId;
	
	private String getewayName;

	public VqDto() {
	}

	public VqDto(Vq v) {
		this.id = v.getId();
		this.collectedTime = v.getCollectedTime();
		this.collectedValue = v.getCollectedValue();
		this.watchId = v.getWatch().getId();
		this.watchName=v.getWatch().getName();
		this.staffId = v.getStaff().getId();
		this.staffName=v.getStaff().getName();
		this.taskId = v.getTask().getId();
		this.taskName = v.getTask().getTitle(); 
		this.gatewayId = v.getGateway().getId();
		this.getewayName = v.getGateway().getName();
	}
	
	public static List<VqDto> getGridData(List<Vq> vs){
		List<VqDto> dtos = new ArrayList<VqDto>();
		for (Vq v: vs){
			dtos.add(new VqDto(v));
		}
		return dtos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWatchName() {
		return watchName;
	}

	public void setWatchName(String watchName) {
		this.watchName = watchName;
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

	public String getGetewayName() {
		return getewayName;
	}

	public void setGetewayName(String getewayName) {
		this.getewayName = getewayName;
	}

	@JsonFormat(pattern = WoConstant.FORMAT_DATETIME, locale = "zh", timezone="GMT+8")
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

	public Vq createEntity () {
		Vq vq = new Vq ();
		vq.setId(WoUtil.uuid());
		vq.setCollectedTime(this.collectedTime);
		vq.setCollectedValue(this.collectedValue);
		if (!WoUtil.isEmpty(gatewayId)) {
			Gateway gw = new Gateway();
			gw.setId(gatewayId);
			vq.setGateway(gw);
		}
		if (!WoUtil.isEmpty(staffId)) {
			Staff staff = new Staff ();
			staff.setId(this.staffId);
			vq.setStaff(staff);
		}
		if (!WoUtil.isEmpty(taskId)) {
			Task task = new Task ();
			task.setId(taskId);
			vq.setTask(task);
		}
		if (!WoUtil.isEmpty(watchId)) {
			Watch watch = new Watch ();
			watch.setId(watchId);
			vq.setWatch(watch);
		}
		return vq;
	}
	
	/**
	 * @param dtos
	 * @return
	 */
	public static List<Vq> createEntities (List<VqDto> dtos) {
		List<Vq> vqs = new ArrayList<Vq>();
		for (VqDto dto : dtos) {
			vqs.add(dto.createEntity());
		}
		return vqs;
	}
	
	@Override
	public String toString() {
		return "VqDto [id=" + id + ", collectedTime=" + collectedTime + ", collectedValue=" + collectedValue
				+ ", watchId=" + watchId + ", watchName=" + watchName + ", staffId=" + staffId + ", staffName="
				+ staffName + ", taskId=" + taskId + ", taskName=" + taskName + ", gatewayId=" + gatewayId
				+ ", getewayName=" + getewayName + "]";
	}

}

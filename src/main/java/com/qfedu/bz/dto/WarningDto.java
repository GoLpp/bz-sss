package com.qfedu.bz.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qfedu.bz.entity.Warning;
import com.qfedu.common.util.WoConstant;

/**
 * @author lenovo
 *
 */
public class WarningDto {
	private final static Logger LOG = LogManager.getLogger(WarningDto.class);
	
	private String id;
	
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern=WoConstant.FORMAT_DATETIME)
	private Date createTime;
	
	private String title;
	
	private String staffId;
	
	private String staffName;
	
	private String taskId;
	
	private String taskName;
	
	public WarningDto() {
		super();
	}
	
	/**
	 * @param warning
	 */
	public WarningDto(Warning warning) {
		this.id = warning.getID();
		this.content = warning.getContent();
		this.createTime = warning.getCreateTime();
		this.title = warning.getTitle();
		this.staffId = warning.getStaff().getId();
		this.staffName = warning.getStaff().getName();
		this.taskId = warning.getTask().getId();
		this.taskName = warning.getTask().getTitle();
	}
	
	/**
	 * @param ws
	 * @return
	 */
	public static List<WarningDto> getDtos(List<Warning> ws){
		List<WarningDto> dtos = new ArrayList<>();
		for(Warning w : ws) {
			dtos.add(new WarningDto(w));
		}
		return dtos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonFormat(pattern=WoConstant.FORMAT_DATETIME, locale="zh", timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	
	
}

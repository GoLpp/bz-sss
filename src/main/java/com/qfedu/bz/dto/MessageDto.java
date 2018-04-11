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
import com.qfedu.bz.entity.Message;
import com.qfedu.common.util.WoConstant;

public class MessageDto {
	private final static Logger LOG = LogManager.getLogger(MessageDto.class);

	private String id;
	
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern=WoConstant.FORMAT_DATETIME)
	private Date releaseTime;
	
	private String title;
	
	private String staffId;
	
	private String staffName;
	
	private String taskId;
	
	private String taskName;
	
	public MessageDto() {
		super();
	}
	
	public MessageDto(Message m) {
		this.id = m.getId();
		this.content = m.getContent();
		this.releaseTime = m.getReleaseTime();
		this.title = m.getTitle();
		this.staffId = m.getStaff().getId();
		this.staffName = m.getStaff().getName();
		this.taskId = m.getTask().getId();
		this.taskName = m.getTask().getTitle();
	}
	
	 
	public static List<MessageDto> getDtos(List<Message> ms){
		List<MessageDto> dtos = new ArrayList<>();
		for(Message w : ms) {
			dtos.add(new MessageDto());
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

	@JsonFormat(pattern=WoConstant.FORMAT_DATETIME,locale="zh",timezone="GMT+8")
	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
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
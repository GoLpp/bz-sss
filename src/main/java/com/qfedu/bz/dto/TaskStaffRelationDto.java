package com.qfedu.bz.dto;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.bz.entity.TaskStaffRelation;

public class TaskStaffRelationDto {
	private final static Logger LOG = LogManager.getLogger(TaskStaffRelationDto.class);

	private String id;
	
	private String positon;
	
	private String taskId;
	
	private String taskName;
	
	private String staffName;
	
	private String staffId;

	public String getId() {
		return id;
	}

	/**
	 * @param t
	 */
	public TaskStaffRelationDto (TaskStaffRelation t) {
		this.id = t.getId();
		this.positon = t.getPositon();
		this.staffId = t.getStaff().getId();
		this.taskId = t.getTask().getId();
		this.taskName = t.getTask().getTitle();
		this.staffName= t.getStaff().getName();
	}
	
	/**
	 * @param ts
	 * @return
	 */
	public static List<TaskStaffRelationDto> getDtos (List<TaskStaffRelation> ts) {
		List<TaskStaffRelationDto> dtos = new ArrayList<TaskStaffRelationDto>();
		for (TaskStaffRelation t : ts) {
			dtos.add(new TaskStaffRelationDto(t));
		}
		return dtos;
	}
	
	public TaskStaffRelationDto() {
		super();
	}

	public TaskStaffRelationDto(String id, String positon, String taskId, String taskName, String staffName,
			String staffId) {
		super();
		this.id = id;
		this.positon = positon;
		this.taskId = taskId;
		this.taskName = taskName;
		this.staffName = staffName;
		this.staffId = staffId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getPositon() {
		return positon;
	}

	public void setPositon(String positon) {
		this.positon = positon;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	
}

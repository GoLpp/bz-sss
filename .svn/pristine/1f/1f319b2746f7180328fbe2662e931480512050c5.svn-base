package com.qfedu.bz.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.bz.entity.Task;
import com.qfedu.bz.entity.TaskStaffRelation;

public class TaskDto {
	private final static Logger LOG = LogManager.getLogger(TaskDto.class);

	private String id;

	private Date actualEndTime;

	private Date actualStartTime;

	private String content;

	private Date planEndTime;

	private Date planStartTime;

	private Date releaseTime;

	private String title;

	private List<TaskStaffRelation> taskStaffRelations;

	private String staffId;

	private Boolean woChecked = false;

	public TaskDto(Task t) {
		this.id = t.getId();
		this.actualEndTime = t.getActualEndTime();
		this.actualStartTime = t.getActualStartTime();
		this.content = t.getContent();
		this.planEndTime = t.getPlanEndTime();
		this.planStartTime = t.getPlanStartTime();
		this.releaseTime = t.getReleaseTime();
		this.title = t.getTitle();
		if (t.getStaff() != null) {
			this.staffId = t.getStaff().getId();
			this.taskStaffRelations = (List<TaskStaffRelation>) t.getTaskStaffRelations().get(0);

		}
	}

	public static List<TaskDto> getDtos(List<Task> ts) {
		List<TaskDto> dtos = new ArrayList<TaskDto>();
		for (Task t : ts) {
			dtos.add(new TaskDto(t));
		}
		return dtos;
	}

	public List<TaskStaffRelation> getTaskStaffRelations() {
		return taskStaffRelations;
	}

	public void setTaskStaffRelations(List<TaskStaffRelation> taskStaffRelations) {
		this.taskStaffRelations = taskStaffRelations;
	}

	public TaskDto(String id, Date actualEndTime, Date actualStartTime, String content, Date planEndTime,
			Date planStartTime, Date releaseTime, String title, List<TaskStaffRelation> taskStaffRelations,
			String staffId, Boolean woChecked) {
		super();
		this.id = id;
		this.actualEndTime = actualEndTime;
		this.actualStartTime = actualStartTime;
		this.content = content;
		this.planEndTime = planEndTime;
		this.planStartTime = planStartTime;
		this.releaseTime = releaseTime;
		this.title = title;
		this.taskStaffRelations = taskStaffRelations;
		this.staffId = staffId;
		this.woChecked = woChecked;
	}

	public TaskDto() {
		super();
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getActualEndTime() {
		return actualEndTime;
	}

	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	public Date getActualStartTime() {
		return actualStartTime;
	}

	public void setActualStartTime(Date actualStartTime) {
		this.actualStartTime = actualStartTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}

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

	public Boolean getWoChecked() {
		return woChecked;
	}

	public void setWoChecked(Boolean woChecked) {
		this.woChecked = woChecked;
	}

}

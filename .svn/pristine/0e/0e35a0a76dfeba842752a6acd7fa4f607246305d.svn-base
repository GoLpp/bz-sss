package com.qfedu.bz.dto;

import org.activiti.engine.task.Task;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.common.util.WoUtil;

public class ActivitiTaskDto {

	private final static Logger LOG = LogManager.getLogger(ActivitiTaskDto.class);

	/**
	 * 流程实例ID
	 */
	private String actProcInstId;
	
	/**
	 * 任务定义key
	 */
	private String actTaskDefinitionKey;

	
	/**
	 * 任务实例ID
	 */
	private String actTaskId;

	/**
	 * 任务名称
	 */
	private String actTaskName;

	public String getActTaskName() {
		if (WoUtil.isEmpty(actTaskName)) {
			if (WoUtil.isEmpty(actTaskId)) {
				return "已结束";
			} else {
				return "未知";
			}
		}
		return actTaskName;
	}

	public void setActTaskName(String actTaskName) {
		this.actTaskName = actTaskName;
	}

	public String getActTaskId() {
		return actTaskId;
	}

	public void setActTaskId(String actTaskId) {
		this.actTaskId = actTaskId;
	}

	public String getActTaskDefinitionKey() {
		return actTaskDefinitionKey;
	}

	public void setActTaskDefinitionKey(String actTaskDefinitionKey) {
		this.actTaskDefinitionKey = actTaskDefinitionKey;
	}

	public String getActProcInstId() {
		return actProcInstId;
	}

	public void setActProcInstId(String actProcInstId) {
		this.actProcInstId = actProcInstId;
	}

	/**
	 * @param t
	 */
	public void setTask (Task t) {
		this.setActProcInstId(t.getProcessInstanceId());
		this.setActTaskDefinitionKey(t.getTaskDefinitionKey());
		this.setActTaskId(t.getId());
		this.setActTaskName(t.getName());
	}
}

package com.qfedu.bz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.esys.entity.Staff;

/**
 * 任务人员关系
 * @author cailei
 *
 */
@Entity
@Table(name = "bz_task_staff")
public class TaskStaffRelation {
	
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(TaskStaffRelation.class);

	@Id
	@Column(length = 50)
	private String id;
	
	/**
	 * 任务
	 */
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;
	
	/**
	 * 参与人
	 */
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;

	/**
	 * 参与人职务
	 */
	@Column(length = 2)
	private String positon;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPositon() {
		return positon;
	}

	public void setPositon(String positon) {
		this.positon = positon;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}

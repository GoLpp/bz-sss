package com.qfedu.bz.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

import com.qfedu.common.util.WoConstant;
import com.qfedu.esys.entity.Staff;

@Entity
@Table(name="bz_warning")
public class Warning {
	private final static Logger LOG = LogManager.getLogger(Warning.class);

	@Id
	@Column(length = 50)
	private String ID;

	/**
	 * 标题
	 */
	@Column(length = 50, nullable = false)
	private String title;
	
	/**
	 * 内容
	 */
	@Column(length = 100)
	private String content;
	
	/**
	 * 产生时间
	 */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date createTime;

	/**
	 * 目标人员
	 */
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;

	/**
	 * 目标任务
	 */
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

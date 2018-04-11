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

/**
 * 消息，主要针对任务。
 * @author cailei
 *
 */
@Entity
@Table(name="bz_message")
public class Message {
	private final static Logger LOG = LogManager.getLogger(Message.class);
	
	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 标题
	 */
	@Column(length=20, nullable = false)
	private String title;
	
	/**
	 * 内容
	 */
	@Column(length=100)
	private String content;
	
	/**
	 * 发布时间
	 */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date releaseTime;
	
	/**
	 * 发布人
	 */
	@ManyToOne
	@JoinColumn(name="staff_id", nullable = false)
	private Staff staff;
	
	/**
	 * 任务
	 */
	@ManyToOne
	@JoinColumn(name="task_id", nullable = false)
	private Task task;

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
	
	
}

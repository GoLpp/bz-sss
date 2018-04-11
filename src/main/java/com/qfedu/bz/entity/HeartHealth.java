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

import org.springframework.format.annotation.DateTimeFormat;

import com.qfedu.common.util.WoConstant;
import com.qfedu.esys.entity.Staff;

/**
 * 心脏健康度
 * @author cailei
 *
 */
@Entity
@Table(name = "bz_health_heart")
public class HeartHealth {

	@Id
	@Column(length = 50)
	private String id;

	/**
	 * 采集时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date collectedTime;

	/**
	 * 采集值，数字，0-200
	 */
	@Column(length = 50, nullable = false)
	private String collectedValue;

	/**
	 * 关联员工
	 */
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;

	/**
	 * 关联任务
	 */
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;

	/**
	 * 关联网关
	 */
	@ManyToOne
	@JoinColumn(name = "weargateway_id")
	private Gateway gateway;

	/**
	 * 关联腕表
	 */
	@ManyToOne
	@JoinColumn(name = "watch_id")
	private Watch watch;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public Gateway getGateway() {
		return gateway;
	}

	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}
	
}

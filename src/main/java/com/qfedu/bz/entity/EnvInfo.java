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
 * 外部环境参数
 * @author 林 龙
 * @version 1.0.0
 *
 */
@Entity
@Table(name = "bz_envinfo")
public class EnvInfo {

	private final static Logger LOG = LogManager.getLogger(EnvInfo.class);

	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 湿度
	 */
	@Column
	private Double humidity;
	
	/**
	 * 压力
	 */
	@Column
	private Double pressure;
	
	/**
	 * 温度
	 */
	@Column
	private Double temperature;
	
	/**
	 * 紫外线强度
	 */
	@Column
	private Double ultravioletrays;
	
	/**
     * 采集时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
    private Date collectedTime;

    /**
     * 关联网关
     */
    @ManyToOne
    @JoinColumn(name = "gateway_id")
    private Gateway gateway;

    /**
     * 关联人员
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

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getUltravioletrays() {
		return ultravioletrays;
	}

	public void setUltravioletrays(Double ultravioletrays) {
		this.ultravioletrays = ultravioletrays;
	}

	public Gateway getGateway() {
		return gateway;
	}

	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
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

	@Override
	public String toString() {
		return "EnvInfo [id=" + id + ", collectedTime=" + collectedTime + ", humidity=" + humidity + ", pressure="
				+ pressure + ", temperature=" + temperature + ", ultravioletrays=" + ultravioletrays + ", gateway="
				+ gateway + ", staff=" + staff + ", task=" + task + "]";
	}
	
}


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
import com.qfedu.esys.entity.Dept;
import com.qfedu.esys.entity.Staff;

/**
 * 腕表，用于采集人体健康数据。
 * @author
 */
@Entity
@Table(name = "bz_watch")
public class Watch {
	private final static Logger LOG = LogManager.getLogger(Watch.class);

	/**
	 * 
	 */
	@Id
	@Column(length = 50)
	private String id;

	/**
	 * 名称
	 */
	@Column(length = 50, nullable = false)
	private String name;

	/**
	 * 编号
	 */
	@Column(length = 50, unique = true, nullable = false)
	private String no;

	/**
	 * 参数
	 */
	@Column(length = 100)
	private String parameters;

	/**
	 * 说明
	 */
	@Column(length = 100)
	private String detail;
	
	/**
	 * 领用时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date userTime;

	/**
	 * 领用人
	 */
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	/**
	 * 所属部门
	 */
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Dept department;

	public Watch() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public void setNo(String no) {
		this.no = no;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Date getUserTime() {
		return userTime;
	}

	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}

	public Dept getDepartment() {
		return department;
	}

	public void setDepartment(Dept department) {
		this.department = department;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}

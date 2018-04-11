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

@Entity
@Table(name="bz_leave")
public class Leave {
	
	/**
	 * ID
	 */
	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 流程实例ID
	 */
	@Column(length=64)
	private String procInstId;
	
	public String getProcInstId() {
		return procInstId;
	}

	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}

	/**
	 * 原因
	 */
	@Column(length=200)
	private String reason;

	/**
	 * 员工
	 */
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;

	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date createTime;
	
	/**
	 * 申请时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date applyTime;
	
	/**
	 * 管理者
	 */
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Staff manager;
	
	/**
	 * 审核时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date reviewTime;
	
	/**
	 * 审核结果
	 */
	@Column
	private Boolean reviewResult = false;
	
	/**
	 * 审核说明
	 */
	@Column(length = 200)
	private String reviewRemark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	public Date getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public Boolean getReviewResult() {
		return reviewResult;
	}

	public void setReviewResult(Boolean reviewResult) {
		this.reviewResult = reviewResult;
	}

	public String getReviewRemark() {
		return reviewRemark;
	}

	public void setReviewRemark(String reviewRemark) {
		this.reviewRemark = reviewRemark;
	}
}

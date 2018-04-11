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
@Table(name="bz_softwareversion")
public class SoftwareVersion {
	private final static Logger LOG = LogManager.getLogger(SoftwareVersion.class);

	@Id
	@Column(length = 50)
	private String id;
	
	@Column(length = 50)
	private String versionId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date releaseTime;
	
	@Column(length = 200)
	private String software;
	
	@Column(length = 200)
	private String description;

	@ManyToOne
	@JoinColumn (name="staff_id")
	private Staff staff;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "SoftwareVersion [id=" + id + ", versionId=" + versionId + ", releaseTime=" + releaseTime + ", software="
				+ software + ", description=" + description + ", staff=" + staff + "]";
	}

	
	
	



}

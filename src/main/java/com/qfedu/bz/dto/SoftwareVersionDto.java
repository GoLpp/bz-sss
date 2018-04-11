package com.qfedu.bz.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.bz.entity.SoftwareVersion;
import com.qfedu.esys.entity.Staff;


public class SoftwareVersionDto {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(SoftwareVersionDto.class);

	private String id;
	
	private String versionId;
	
	private Date releaseTime;
	
	private String software;
	
	private String description;

	private Staff staff;
	
	private String staffId;
	
	private String staffName;
	
	public SoftwareVersionDto () {
		super();
	}
	public SoftwareVersionDto (SoftwareVersion s) {
		this.id = s.getId();
		this.versionId = s.getVersionId();
		this.releaseTime = s.getReleaseTime();
		this.software = s.getSoftware();
		this.description = s.getDescription();
		this.staff = s.getStaff();
		this.staffId = staff.getId();
		this.staffName = staff.getName();
	}
	

	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
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
	public static List<SoftwareVersionDto> getList(List<SoftwareVersion> list) {
		List<SoftwareVersionDto> dtos = new ArrayList<SoftwareVersionDto>();
		for(SoftwareVersion s : list) {
			SoftwareVersionDto dto = new SoftwareVersionDto(s);
			dtos.add(dto);
		}
		return dtos;
	}
	
	
}

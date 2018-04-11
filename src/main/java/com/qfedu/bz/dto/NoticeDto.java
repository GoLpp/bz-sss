package com.qfedu.bz.dto;

import java.util.ArrayList;
import java.util.List;

import com.qfedu.bz.entity.Notice;
import com.qfedu.common.util.WoUtil;
import com.qfedu.esys.entity.Dept;

public class NoticeDto {
	private  String id;
	private  String title;
	private  String content;
	private  String releaseTime;
	private  String staffId;
	private  String staffName;
	private 	 String departmentId;
	private  String departmentName;
	
	
	public NoticeDto(Notice notice) {
		
		id = notice.getId();
		title = notice.getTitle();
		content = notice.getContent();
		releaseTime = notice.getReleaseTime()+"";
		
		if(notice.getStaff()!=null) {
			staffId = notice.getStaff().getId();
			staffName = notice.getStaff().getName();
		}
		if(notice.getDepts()!=null) {
			for (Dept d: notice.getDepts()) {
				if(!WoUtil.isEmpty(departmentId)) {
				departmentId +=",";
				departmentName +=",";
		}
				departmentId += d.getId();
				departmentName += d.getName();
			}

		}
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getReleaseTime() {
		return releaseTime;
	}


	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
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


	public String getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public static List<NoticeDto> getDtos(List<Notice> list) {
		List<NoticeDto> arrayList = new ArrayList<>();
		for (Notice notice : list) {
			NoticeDto noticeDto = new NoticeDto(notice);
			arrayList.add(noticeDto);
		}
		return arrayList;
		
	}
	
	
}

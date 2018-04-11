package com.qfedu.bz.entity;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * 公告
 * @author cailei
 *
 */
@Entity
@Table(name="bz_notice")
public class Notice {
	private final static Logger LOG = LogManager.getLogger(Notice.class);
	
	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 标题
	 */
	@Column(length=50, nullable = false)
	private String title;
	
	/**
	 * 内容
	 */
	@Column(length = 100)
	private String content;
	
	/**
	 * 过期时间，必填
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date expirationTime;
	
	/**
	 * 发布时间，必填
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
	private Date releaseTime;
	
	/**
	 * 发布人，必填
	 */
	@ManyToOne
	@JoinColumn(name = "staff_id", nullable = false)
	private Staff staff; 
	
	/**
	 * 部门，必填
	 */
	@ManyToMany
	@JoinTable(name="bz_notice_dept",
	joinColumns= {@JoinColumn(name="notice_id")},
			inverseJoinColumns = { @JoinColumn(name = "dept_id")})
	private List<Dept> depts;

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

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
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

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	public Notice() {
		super();
	}

	public Notice(String id, String content, Date expirationTime, Date releaseTime, String title, Staff staff,
			List<Dept> depts) {
		super();
		this.id = id;
		this.content = content;
		this.expirationTime = expirationTime;
		this.releaseTime = releaseTime;
		this.title = title;
		this.staff = staff;
		this.depts = depts;
	}
}

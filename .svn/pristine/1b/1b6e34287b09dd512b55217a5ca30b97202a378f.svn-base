package com.qfedu.esys.entity;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

import com.qfedu.common.util.WoConstant;

@Entity
@Table(name="sys_staff")
public class Staff {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(Staff.class);
	
	@Id
	@Column(length = 50)
	private String id;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 200)
	private String headImage;
	
	@Column(length = 2)
	private String sex;
	
	@Column(length = 50)
	private String no;
	
	@Column(length = 30)
	private String mobile;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern=WoConstant.FORMAT_DATE)
	private Date birthday;
	
	@Column(length = 200)
	private String idCard;
	
//	@OneToMany
//	@JoinColumn(name="staff_id")
	@OneToMany (mappedBy = "staff")
	private List<StaffDeptRelation> relations;
	
	//关联用户，多对一，外键user_id
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

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

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public List<StaffDeptRelation> getRelations() {
		return relations;
	}

	public void setRelations(List<StaffDeptRelation> relations) {
		this.relations = relations;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", headImage=" + headImage + ", sex=" + sex + ", no=" + no
				+ ", birthday=" + birthday + ", idCard=" + idCard + ", user=" + user + "]";
	}
	
}

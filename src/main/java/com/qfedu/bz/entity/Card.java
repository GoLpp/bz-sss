package com.qfedu.bz.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.esys.entity.Staff;

/**
 * 工卡（IC卡）
 * @author cailei
 *
 */
@Entity
@Table(name="bz_iccard")
public class Card {
	private final static Logger LOG = LogManager.getLogger(Card.class);

	/**
	 * 
	 */
	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 编号
	 */
	@Column(length=50, unique = true, nullable = false)
	private String no;
	
	/**
	 * 说明
	 */
	@Column(length=200)
	private String description;
	
	/**
	 * 关联人员
	 */
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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
}

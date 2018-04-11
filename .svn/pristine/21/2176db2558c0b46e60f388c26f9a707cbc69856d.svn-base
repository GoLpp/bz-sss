package com.qfedu.esys.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Entity
@Table(name="sys_dept")
public class Dept {
	
	private final static Logger LOG = LogManager.getLogger(Dept.class);
	
	@Id
	@Column(length = 50)
	private String id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String no;
	
	@Column(length = 200)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Dept parent;

	@OneToMany(mappedBy="parent")
	private List<Dept> children;

	@OneToMany(mappedBy="dept")
	private List<StaffDeptRelation> relations;
	
	public List<StaffDeptRelation> getRelations() {
		return relations;
	}

	public void setRelations(List<StaffDeptRelation> relations) {
		this.relations = relations;
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

	public void setNo(String no) {
		this.no = no;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Dept getParent() {
		return parent;
	}

	public void setParent(Dept parent) {
		this.parent = parent;
	}

	public List<Dept> getChildren() {
		return children;
	}

	public void setChildren(List<Dept> children) {
		this.children = children;
	}
	
}

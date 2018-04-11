package com.zhu.pojo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Man {
	private final static Logger LOG = LogManager.getLogger(Man.class);
	
	private String name;
	
	private Integer age;

	public Man() {
	}

	public Man(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + "]";
	}
}

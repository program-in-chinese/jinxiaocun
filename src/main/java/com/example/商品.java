package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class 商品 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String 名称;
	private String 单位;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return 名称;
	}
	public void setName(String name) {
		this.名称 = name;
	}
	public String getUnit() {
		return 单位;
	}
	public void setUnit(String 单位) {
		this.单位 = 单位;
	}
}

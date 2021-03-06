package com.api.student.studentrestapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer departmentId;
	
	private String deptartmentName;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDeptartmentName() {
		return deptartmentName;
	}

	public void setDeptartmentName(String deptartmentName) {
		this.deptartmentName = deptartmentName;
	}
	
	

}

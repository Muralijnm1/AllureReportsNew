package com.AllureReports.Resources;

public class DepartmentDetails {
	private String deptName;
	DepartmentTypeDetails dTypeDetails;
	public DepartmentTypeDetails getdTypeDetails() {
		return dTypeDetails;
	}
	public void setdTypeDetails(DepartmentTypeDetails dTypeDetails) {
		this.dTypeDetails = dTypeDetails;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	private int id;
	private String location;

}

package org.yby.entity;

public class Student {
	private int stuNo;
	private String name;
	private int stuAge;
	private String graName;
	private boolean stuSex;
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


	
	
	public Student() {
		
	}
	public Student(int stuNo, String name, int stuAge, String graName) {
		this.stuNo = stuNo;
		this.name = name;
		this.stuAge = stuAge;
		this.graName = graName;
	}
	public Student(int stuNo, String name, int stuAge, String graName,Address address) {
		this.stuNo = stuNo;
		this.name = name;
		this.stuAge = stuAge;
		this.graName = graName;
		this.address = address;
	}

	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getGraName() {
		return graName;
	}
	public void setGraName(String graName) {
		this.graName = graName;
	}

	
	public boolean isStuSex() {
		return stuSex;
	}
	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
	}


	@Override
	public String toString() {
		return this.getStuNo()+"*"+this.getName()+"*"+this.getStuAge()+"*"+this.getGraName()+"*"+this.stuSex+"*"+this.getAddress();
	}
	
	
}

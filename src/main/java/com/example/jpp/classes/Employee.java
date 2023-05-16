package com.example.jpp.classes;

public class Employee {
	private String imagePath;
    private String name;
    private String designation;
    private String phone;
    private String emailId;
    
	public Employee() {
		super();
	}

	public Employee(String image, String name, String designation, String phone, String emailId) {
		super();
		this.imagePath = image;
		this.name = name;
		this.phone = phone;
		this.emailId = emailId;
		this.designation = designation;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String image) {
		this.imagePath = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}

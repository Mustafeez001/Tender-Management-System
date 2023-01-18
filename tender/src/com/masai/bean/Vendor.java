package com.masai.bean;

public class Vendor {

	private String vid;
	private String vname;
	private String email;
	private String password;
	private String company;
	private String address;
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(String vid, String vname, String email, String password, String company, String address) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.email = email;
		this.password = password;
		this.company = company;
		this.address = address;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vname=" + vname + ", email=" + email + ", password=" + password + ", company="
				+ company + ", address=" + address + "]";
	}
	
	
}

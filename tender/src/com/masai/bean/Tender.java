package com.masai.bean;

public class Tender {
private int tid;
private int flatType;
private String location;
private String startDate;
private String endDate;
private double basePrice;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public int getFlatType() {
	return flatType;
}
public void setFlatType(int flatType) {
	this.flatType = flatType;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public double getBasePrice() {
	return basePrice;
}
public void setBasePrice(double basePrice) {
	this.basePrice = basePrice;
}
public Tender(int tid, int flatType, String location, String startDate, String endDate, double basePrice) {
	super();
	this.tid = tid;
	this.flatType = flatType;
	this.location = location;
	this.startDate = startDate;
	this.endDate = endDate;
	this.basePrice = basePrice;
}
@Override
public String toString() {
	return "Tender [tid=" + tid + ", flatType=" + flatType + ", location=" + location + ", startDate=" + startDate
			+ ", endDate=" + endDate + ", basePrice=" + basePrice + "]";
}

}

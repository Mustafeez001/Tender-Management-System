package com.masai.dao;

//import java.sql.SQLException;
import java.util.List;

import com.masai.bean.Tender;
import com.masai.bean.Vendor;
import com.masai.exception.VendorException;


public interface AdminDao {

	public String registerVendor(Vendor vendor);
	
	public boolean loginVendor(String email,String password) throws VendorException;
	
	public List<Vendor> viewAllVendor() throws VendorException;
	
	public boolean loginAdmin(String username,String password) throws VendorException;
	
	public String createTender(Tender tender);
	
	public List<Tender> viewTender() throws VendorException;
	
	public String placeBid(int tid,int vid,double offer) throws VendorException;
	
	public void viewBid(int tid) throws VendorException;
	
	public String assignTender(int tid) throws VendorException;
	
	public void viewBidHistory(int vid) throws VendorException;	
	
}
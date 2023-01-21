package com.masai.useCases;

import java.util.Scanner;

import com.masai.bean.Vendor;
import com.masai.custom.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImp;

public class RegisterVendorUseCase {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Vendor Name:");
	String vname=sc.next();
	
	System.out.println(ConsoleColors.ORANGE+"Enter Email:"+ConsoleColors.RESET);
	String email=sc.next();
	
	System.out.println(ConsoleColors.ORANGE+"Enter Password:"+ConsoleColors.RESET);
	String pass=sc.next();
	
	System.out.println(ConsoleColors.ORANGE+"Enter Your Company:"+ConsoleColors.RESET);
	String comp=sc.next();
	
	System.out.println(ConsoleColors.ORANGE+"Enter Address:"+ConsoleColors.RESET);
	
	String add=sc.next();
	Vendor vendor = new Vendor();
	vendor.setVname(vname);
	vendor.setEmail(email);
	vendor.setPassword(pass);
	vendor.setCompany(comp);
	vendor.setAddress(add);
	AdminDao tdao = new AdminDaoImp();
	String result = tdao.registerVendor(vendor);
	System.out.println(ConsoleColors.RESET+result+ConsoleColors.RESET);
}
}

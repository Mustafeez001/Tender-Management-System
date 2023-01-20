package com.masai.useCases;

import java.util.List;

import com.masai.bean.Vendor;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImp;
import com.masai.exception.VendorException;

public class viewAllVendorUseCase {

	public static void main(String[] args) {
		AdminDao vd = new AdminDaoImp();
		try {
			List<Vendor> vendors = vd.viewAllVendor();
			vendors.forEach(v->{
				System.out.println("Vendor name : "+ v.getVname());
				System.out.println("Vendor email : "+v.getEmail());
				System.out.println("Vendor company : "+v.getCompany());
				System.out.println("vendor address : "+v.getAddress());
				System.out.println("===============================");
			});
		} catch (VendorException v) {
			System.out.println(v.getMessage());
		}

	}

}

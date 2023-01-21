package com.masai.useCases;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.masai.bean.Tender;
import com.masai.bean.Vendor;
import com.masai.custom.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImp;
import com.masai.exception.VendorException;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class useCase {

	public static void main(String[] args) {
		System.out.println(ConsoleColors.GREEN+"                                 \n"
				+ "                                       █░█░█ █▀▀ █░░ █▀▀ █▀█ █▀▄▀█ █▀▀\n"
				+ "                                       ▀▄▀▄▀ ██▄ █▄▄ █▄▄ █▄█ █░▀░█ ██▄");
		System.out.println("\n"
				+ "▀█▀ █▀█   ▀█▀ █░█ █▀▀   ▀█▀ █▀▀ █▄░█ █▀▄ █▀▀ █▀█   █▀▄▀█ ▄▀█ █▄░█ ▄▀█ █▀▀ █▀▀ █▀▄▀█ █▀▀ █▄░█ ▀█▀   █▀ █▄█ █▀ ▀█▀ █▀▀ █▀▄▀█\n"
				+ "░█░ █▄█   ░█░ █▀█ ██▄   ░█░ ██▄ █░▀█ █▄▀ ██▄ █▀▄   █░▀░█ █▀█ █░▀█ █▀█ █▄█ ██▄ █░▀░█ ██▄ █░▀█ ░█░   ▄█ ░█░ ▄█ ░█░ ██▄ █░▀░█"+ConsoleColors.RESET);
		
		System.out.println("                                                      ");
		
		System.out.println(ConsoleColors.BLUE+ "Select 1 for login as Administrator"+ConsoleColors.RESET);
		
		System.out.println(ConsoleColors.GREEN+"Select 2 for login as Vendor"+ConsoleColors.RESET);
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		AdminDao vdao = new AdminDaoImp();
		
		if(x==1) {
			
			System.out.println(ConsoleColors.BLUE+"Please enter username...."+ConsoleColors.RESET);
			String u = sc.next();
			System.out.println(ConsoleColors.RED+"Please enter your password..."+ConsoleColors.RESET);
			String p = sc.next();
			boolean flag=true;
			boolean b;
			try {
				b = vdao.loginAdmin(u, p);
				if(b) {
					System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"Login successfully!!..."+ConsoleColors.RESET);
				}
			} catch (VendorException e1) {
				System.out.println(e1.getMessage());
				flag=false;
			}
			while(flag) {
				try {
					
					if(vdao.loginAdmin(u, p)) {
						System.out.println(" ");
						System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+" ⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼"+ConsoleColors.RESET);
						System.out.println(" ");
						System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT+"Select 1 for registering new vendor \n"
								+ "Select 2 for view all Vendors\n"
								+ "Select 3 for create new Tender\n"
								+ "Select 4 for view all tenders\n"
								+ "Select 5 for view all bids of a tender\n"
								+ "Select 6 to assign a tender\n"
								+ "Select 7 to Exit "+ ConsoleColors.RESET);
						System.out.println(" ");
						
						System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+" ⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼"+ConsoleColors.RESET);
						System.out.println("");
						
						int choice = sc.nextInt();
						switch(choice) {
						case 1 :
							System.out.println(ConsoleColors.BLUE+"Enter Vendor Name:"+ConsoleColors.RESET);
							String vname=sc.next();
							
							
							System.out.println(ConsoleColors.BLUE+"Enter Email:");
							String email=sc.next();
							
							System.out.println(ConsoleColors.RED+"Enter Password:"+ConsoleColors.RESET);
							String pass=sc.next();
							
							System.out.println(ConsoleColors.BLUE+"Enter Your Company:"+ConsoleColors.RESET);
							String comp=sc.next();
							
							System.out.println(ConsoleColors.BLUE+"Enter Address:"+ConsoleColors.RESET);
							
							String add=sc.next();
							
							Vendor vendor = new Vendor();
							
							vendor.setVname(vname);
							
							vendor.setEmail(email);
							
							vendor.setPassword(pass);
							
							vendor.setCompany(comp);
							
							vendor.setAddress(add);
							
							AdminDao tdao = new AdminDaoImp();
							
							String result = tdao.registerVendor(vendor);
							System.out.println(result);
							System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+" ⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼"+ConsoleColors.RESET);
							break;
						case 2:
							AdminDao vd = new AdminDaoImp();
							try {
								List<Vendor> vendors = vd.viewAllVendor();
								vendors.forEach(v->{
									System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ "Vendor name : "+ v.getVname()+ConsoleColors.RESET);
									System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"Vendor email : "+v.getEmail()+ConsoleColors.RESET);
									System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT +"Vendor company : "+v.getCompany()+ConsoleColors.RESET);
									System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT +"vendor address : "+v.getAddress()+ConsoleColors.RESET);
									System.out.println(" ");
									System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+" ⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼"+ConsoleColors.RESET);
									System.out.println(" ");
								});
							} catch (VendorException v) {
								System.out.println(v.getMessage());
							}
							break;
							
						case 3:
							
							System.out.println(" Enter Tender id");
							
							int tid = sc.nextInt();
							
							System.out.println(ConsoleColors.ORANGE+"Enter Units Type in Quantity"+ConsoleColors.RESET);
							int fType = sc.nextInt();
							
							System.out.println(ConsoleColors.ORANGE+"Enter tender location"+ConsoleColors.RESET);;
							String l = sc.next();
							System.out.println(ConsoleColors.ORANGE+"Enter tender start date in yyyy-mm-dd"+ConsoleColors.RESET);
							String sdate = sc.next();
							System.out.println(ConsoleColors.ORANGE+"Enter tender end date in yyyy-mm-dd"+ConsoleColors.RESET);
							String edate = sc.next();
							System.out.println(ConsoleColors.ORANGE+"Enter base price"+ConsoleColors.RESET);
							double price = sc.nextDouble();
							Tender tender = new Tender(tid, fType, l, sdate, edate, price);
							AdminDao ad = new AdminDaoImp();
							String tresult = ad.createTender(tender);
							System.out.println(tresult);
							System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+" ⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼"+ConsoleColors.RESET);
							
							break;
							
						case 4:
							
							AdminDao adao = new AdminDaoImp();
							
							try {
								
								List<Tender> tenders = adao.viewTender();
								
								tenders.forEach(t->{
							  System.out.println("Tender id is : "+t.getTid());
	                          System.out.println("Unit  type in : "+ t.getFlatType()+" Quantity");
	                          System.out.println("Tender location : "+t.getLocation());
	                          System.out.println("Tender start date : "+t.getStartDate());
	                          System.out.println("Tender end date : "+t.getEndDate());
	                          System.out.println("Tender base price : "+t.getBasePrice());
	                          System.out.println(" ");
	                          
	                          System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+" ⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼"+ConsoleColors.RESET);	
	                          
							});
								
							} catch (VendorException e) {
								System.out.println(e.getMessage());
							}
							break;
							
						case 5:
							
						    AdminDao a = new AdminDaoImp();
							System.out.println(ConsoleColors.RESET+"Enter tender id to see all bids"+ConsoleColors.RESET);
							int t= sc.nextInt();
							a.viewBid(t);
							System.out.println(ConsoleColors.RED_BACKGROUND+"=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷=̷"+ConsoleColors.RESET);
							break;
							
						case 6:
							
							AdminDao ab = new AdminDaoImp();
							System.out.println(ConsoleColors.RESET+"Enter tender id .."+ConsoleColors.RESET);
							int ti = sc.nextInt();
							String res = ab.assignTender(ti);
							System.out.println(res);
							break;
							
						case 7:
							
							flag=false;
							System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"\n"
									+ "████████╗██╗░░██╗░█████╗░███╗░░██╗██╗░░██╗  ██╗░░░██╗░█████╗░██╗░░░██╗\n"
									+ "╚══██╔══╝██║░░██║██╔══██╗████╗░██║██║░██╔╝  ╚██╗░██╔╝██╔══██╗██║░░░██║\n"
									+ "░░░██║░░░███████║███████║██╔██╗██║█████═╝░  ░╚████╔╝░██║░░██║██║░░░██║\n"
									+ "░░░██║░░░██╔══██║██╔══██║██║╚████║██╔═██╗░  ░░╚██╔╝░░██║░░██║██║░░░██║\n"
									+ "░░░██║░░░██║░░██║██║░░██║██║░╚███║██║░╚██╗  ░░░██║░░░╚█████╔╝╚██████╔╝\n"
									+ "░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝  ░░░╚═╝░░░░╚════╝░░╚═════╝░!!...."+ConsoleColors.BLUE_BACKGROUND_BRIGHT);
							break;
						}
					}
				
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			
		}else if(x==2) {
			System.out.println(ConsoleColors.ORANGE+"Please enter your email.."+ConsoleColors.RESET);
			String email = sc.next();
			System.out.println(ConsoleColors.ORANGE+"Enter your password");
			String pass = sc.next();
			boolean flag=true;
			boolean b;
			try {
				b = vdao.loginVendor(email, pass);
				if(b) {
					System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"Login successfully!!..."+ConsoleColors.BLUE_BACKGROUND_BRIGHT);
				}
			} catch (VendorException e1) {
				System.out.println(e1.getMessage());
				flag=false;
			}
			while(flag) {
				try {
					if(vdao.loginVendor(email, pass)) {
						System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Select 1 for view all current tenders\n"
								+ "Select 2 for place a bid against a tender\n"
								+ "Select 3 for view status of bids\n"
								+ "Select 4 for view own bid history\n"
								+ "Select 5 for Exit..."+ConsoleColors.RESET);
						int choice = sc.nextInt();
						switch(choice) {
						case 1:
							AdminDao adao = new AdminDaoImp();
							try {
								List<Tender> tenders = adao.viewTender();
								tenders.forEach(t -> {
	                          System.out.println(ConsoleColors.CYAN_BOLD+"Tender id is : "+t.getTid()+ConsoleColors.RESET);
	                          System.out.println(ConsoleColors.CYAN_BOLD+"Unit in  : "+ t.getFlatType()+" Quantity"+ConsoleColors.RESET);
	                          System.out.println(ConsoleColors.CYAN_BOLD+"Tender location : "+t.getLocation()+ConsoleColors.RESET);
	                          System.out.println(ConsoleColors.CYAN_BOLD+"Tender start date : "+t.getStartDate()+ConsoleColors.RESET);
	                          System.out.println(ConsoleColors.CYAN_BOLD+"Tenser end date : "+t.getEndDate()+ConsoleColors.RESET);
	                          System.out.println(ConsoleColors.CYAN_BOLD+"Tender base price : "+t.getBasePrice()+ConsoleColors.RESET);
	                          System.out.println(" ");
	                           System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+" ⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼⁼"+ConsoleColors.RESET);
	                           System.out.println(" ");
	                           
								});
								
							} catch (VendorException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 2:
							System.out.println(ConsoleColors.PURPLE_BRIGHT+ "Welcome to place a bid..."+ ConsoleColors.RESET);
							System.out.println(ConsoleColors.PURPLE_BRIGHT+"Enter tender Id"+ConsoleColors.RESET);
							int tid = sc.nextInt();
							System.out.println(ConsoleColors.PURPLE_BRIGHT+"Enter Vendor Id"+ConsoleColors.RESET);
							int vid = sc.nextInt();
							System.out.println(ConsoleColors.PURPLE_BRIGHT+"Enter your bid offer"+ConsoleColors.RESET);
							double offer = sc.nextDouble();
							AdminDao dao = new AdminDaoImp();
			                 try {
							String result=dao.placeBid(tid, vid, offer);
							System.out.println(result);
							} catch (Exception e) {
							System.out.println(e.getMessage());
							}
			                 break;
						case 3:
							AdminDao ab = new AdminDaoImp();
							System.out.println("Enter tender id ..");
							int ti = sc.nextInt();
							String res = ab.assignTender(ti);
							System.out.println(res);
							break;
						case 4:
							System.out.println("Enter your Vender id ");
							AdminDao abc = new AdminDaoImp();
							int vi = sc.nextInt();
							abc.viewBidHistory(vi);
							break;
						case 5:
							System.out.println((ConsoleColors.BLUE_BACKGROUND_BRIGHT+"\n"
									+ "████████╗██╗░░██╗░█████╗░███╗░░██╗██╗░░██╗  ██╗░░░██╗░█████╗░██╗░░░██╗\n"
									+ "╚══██╔══╝██║░░██║██╔══██╗████╗░██║██║░██╔╝  ╚██╗░██╔╝██╔══██╗██║░░░██║\n"
									+ "░░░██║░░░███████║███████║██╔██╗██║█████═╝░  ░╚████╔╝░██║░░██║██║░░░██║\n"
									+ "░░░██║░░░██╔══██║██╔══██║██║╚████║██╔═██╗░  ░░╚██╔╝░░██║░░██║██║░░░██║\n"
									+ "░░░██║░░░██║░░██║██║░░██║██║░╚███║██║░╚██╗  ░░░██║░░░╚█████╔╝╚██████╔╝\n"
									+ "░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝  ░░░╚═╝░░░░╚════╝░░╚═════╝░!!...."+ConsoleColors.BLUE_BACKGROUND_BRIGHT));
							flag = false;
							return;
						}
				}
					} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
				
		}else {
			System.out.println("Please enter valid number");
		}

	}

}

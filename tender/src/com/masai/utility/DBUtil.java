package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection provideConnection() {
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Problem in loading the driver....");
			e.printStackTrace();
		}
		
		
		String url="jdbc:mysql://localhost:3306/test2";
		
		
		try {
			con=DriverManager.getConnection(url,"root","Mindhunter@1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
	}
}

package com.mini1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class User_RegisterConnection {
	//1.create connction for inputing user data
	Connection con=null;
	
	public Connection  register() {
		System.out.println("Hello Human being , "
				+ "Plese Enter to continue ");
		Scanner scan=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
		
	}
	
	

}

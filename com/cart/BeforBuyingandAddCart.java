package com.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mini1.User_Register1;

public class BeforBuyingandAddCart  {
	public  void BBA() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your  gmail to varify & adding into cart for buy products");
		String un=scan.next();
		try {
			//Scanner scan = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			//System.out.println("Enter your email");
			//String mail = scan.next();
			PreparedStatement prp = con.prepareStatement("SELECT * FROM user.record where name='" + un + "'");

			
			ResultSet rs = prp.executeQuery();
			if (rs.next()) {
				System.out.println("Your gmail is vaild  \t)");
				
				System.out.println("You Can Buy Below Products!");
				
			} else
				
				System.out.println("Invaild gmail Please Register First");
			User_Register1 uk=new User_Register1();
			
			
				
				

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
}

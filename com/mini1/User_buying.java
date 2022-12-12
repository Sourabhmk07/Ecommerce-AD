package com.mini1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_buying {
	//3.After login connection showing data to user

	public void datainsert() {
		User_Register1 u1 = new User_Register1();
		u1.inputdata();
		System.out.println("\t");
		
	}
	public void showproduct() {
		try {
			this.datainsert();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			PreparedStatement prp = con.prepareStatement("SELECT * FROM estore.product");
			
			ResultSet rs = prp.executeQuery();
			while (rs.next()) {
				System.out.println("Product_id=" + rs.getInt(1) );

				System.out.println("name=" + rs.getString(2));

				System.out.println("description=" + rs.getString(3));
				System.out.println("price=" + rs.getString(4));
				System.out.println("quantity=" + rs.getString(5));
				System.out.println("\t");

			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
	}

	public static void main(String[] args) {
		User_buying ub = new User_buying();
		//ub.datainsert();
		ub.showproduct();

		
	}

}

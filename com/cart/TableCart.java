package com.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mini1.LoginIdentification;
import com.mini1.forloginExpection;

public class TableCart {
	static String nav;

	public static void usersCarttablecreation(String nav) {

		try {
			Scanner scan = new Scanner(System.in);

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart", "root", "root");

			PreparedStatement prp = con.prepareStatement("create table " + nav
					+ "( id int not null auto_increment primary key,User_gmail varchar(100),product_name varchar(100),price int,description varchar(100))");
			int s=prp.executeUpdate();
			
			
			//TableCart tc = new TableCart();
			// tc.addcart(null, 0, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addcart(String nav,String name3, int price3, String description3) {
		TableCart tc = new TableCart();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart", "root", "root");

			PreparedStatement prp = con
					.prepareStatement("insert into "+nav+" (User_gmail,product_name,price,description)values(?,?,?,?)");
			prp.setString(1, nav);
			prp.setString(2, name3);
			prp.setInt(3, price3);
			prp.setString(4, description3);

			int i = prp.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TableCart tc = new TableCart();

	}

}

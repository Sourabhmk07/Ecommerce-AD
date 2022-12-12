package com.mini1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User_Register1 {
	static String s;
	static String c1;
	static String c2;
	static String c3;

	// 2.creating connection between them
	public void insertRegister(String gmail, String name, String password) {
		User_RegisterConnection uc = new User_RegisterConnection();
		Connection con = uc.register();
		try {
			PreparedStatement pep = con.prepareStatement("insert into record(gmail,name,password)values(?,?,?)");
			pep.setString(1, gmail);
			pep.setString(2, name);
			pep.setString(3, password);
			int i = pep.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void inputdata() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hey!!!!! Welcome to iUniverse");
		System.out.println("Enter 1 for Register & 2 for login");
		System.out.println("Enter your number");
		int num = scan.nextInt();
		switch (num) {
		case 1:
			System.out.println("Enter your Email");
			String gmail1 = scan.next();
			System.out.println("Enter your Name");
			String name1 = scan.next();
			System.out.println("Enter Your password");
			String password1 = scan.next();
			System.out.println("Registration Sucessfully");
			User_Register1 uu = new User_Register1();
			uu.insertRegister(gmail1, name1, password1);
			System.out.println("please Login again");
			// insertRegister ir=new insertRegister(gmail1,name1,password1);
			System.out.println("\t");

		case 2:
			System.out.println("Please Enter your Details");
			LoginIdentification ll = new LoginIdentification();
			ll.loginmail();
			 ll.passwordcheck();
			 

		

			/*
			 * case 2: System.out.println("Enter your EmailId"); String gmail=scan.next();
			 * System.out.println(" Please Enter Your Name "); String name = scan.next();
			 * System.out.println("Enter your password"); String password = scan.next();
			 * User_Register1 uu = new User_Register1(); uu.insertRegister(gmail, name,
			 * password);
			 */
		}

		/*
		 * User_Register1 uu = new User_Register1(); uu.insertRegister(gmail, name,
		 * password);
		 */

	}

	public static void main(String[] args) {
		User_Register1 uu = new User_Register1();
		uu.inputdata();

	}

}

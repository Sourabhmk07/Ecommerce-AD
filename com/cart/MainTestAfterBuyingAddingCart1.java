package com.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mini1.User_Register1;
import com.mini1.User_buying;

public class MainTestAfterBuyingAddingCart1 {
	//This is MainTesting Class
	

	static int total;

	public void grtintocart() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your  gmail to varify & adding into cart for buy products");
		String un = scan.next();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			// System.out.println("Enter your email");
			// String mail = scan.next();
			PreparedStatement prp = con.prepareStatement("SELECT * FROM user.record where name='" + un + "'");

			ResultSet rs = prp.executeQuery();
			if (rs.next()) {
				System.out.println("Your gmail is vaild  \t)");

				System.out.println("You Can Buy Below Products!");

			} else {

				System.out.println("Invaild gmail Please Register First");
				User_Register1 uk = new User_Register1();
				uk.inputdata();
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		System.out.println(" How many product u want to buy (u can buy only 5 product at a time) >>Enter number ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
				System.out.println("Enter product Id to buy");
				int id = scan.nextInt();
				PreparedStatement prp = con
						.prepareStatement("SELECT * FROM estore.product WHERE product_id='" + id + "'");
				Connection con1 = null;

				ResultSet rs = prp.executeQuery();
				while (rs.next()) {
					System.out.println("Product_id=" + rs.getInt(1));

					System.out.println("name=" + rs.getString(2));

					System.out.println("description=" + rs.getString(3));
					System.out.println("price=" + rs.getInt(4));
					TableCart tc = new TableCart();
					
					tc.addcart(un, rs.getString(2), rs.getInt(4), rs.getString(3));// adding product to cart
					//after buying quantity from product decrease from table
					QuantityDecrease qd=new QuantityDecrease();
					qd.Forquantity(id);
					
					
					String t = null;
					total = total + rs.getInt(4);

					// System.out.println("quantity=" + rs.getString(5));

					/*
					 * PreparedStatement prp1 = con1
					 * .prepareStatement("insert into cart(Product_name,price,description)values(");
					 * ResultSet rs1 = prp1.executeQuery();
					 */
					System.out.println("\t");

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("Your Cart Details \t");// after adding to cart showing
			// details of cart and price

			// System.out.println(tc.addcart( rs.getString(2), rs.getInt(4),
			// rs.getString(3));
			System.out.println("total bill price is " + total);
		}

	}

	public static void main(String[] args) {
		MainTestAfterBuyingAddingCart1 a1 = new MainTestAfterBuyingAddingCart1();
		User_buying ub = new User_buying();
		// ub.datainsert();
		ub.showproduct();
		a1.grtintocart();
		// 5. Once the user selected the product then adds that product to cart

	}

}

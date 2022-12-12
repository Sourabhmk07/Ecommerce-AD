package com.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuantityDecrease {
	public void Forquantity(int d) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "root");
			PreparedStatement prp = con.prepareStatement("SELECT * FROM estore.product where product_id= "+d+" ");
			
			ResultSet rs = prp.executeQuery();
			

			while (rs.next()) {
				System.out.println("quantity=" + rs.getInt(5));
				int temp = (rs.getInt(5));
				temp = temp - 1;
				System.out.println(temp);
				PreparedStatement prp1 = con
						.prepareStatement("update estore.product set quantity= " + temp + " where product_id= "+d+" ");
				int o = prp1.executeUpdate();

				// System.out.println("Product_id=" + rs.getInt(1) );

				// System.out.println("name=" + rs.getString(2));

				// System.out.println("description=" + rs.getString(3));
				// System.out.println("price=" + rs.getString(4));

				// System.out.println("\t");

			}
			// r= r-1;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

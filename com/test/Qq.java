package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Qq {
	//static int temp;
	public void Forquantity() {
		try {
			//this.datainsert();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "root");
			PreparedStatement prp = con.prepareStatement("SELECT * FROM estore.product where product_id=1");
			// System.out.println(prp);
			ResultSet rs = prp.executeQuery();
			//int temp=0;
			
			while (rs.next()) {
				System.out.println("quantity=" + rs.getInt(5));
				int  temp=(rs.getInt(5));
				temp=temp-1;
				System.out.println(temp);
				PreparedStatement prp1 = con.prepareStatement("update estore.product set quantity= "+temp+" where product_id=1 ");
				int o=prp1.executeUpdate();
				
				
				
				
				
				
				//System.out.println("Product_id=" + rs.getInt(1) );

				//System.out.println("name=" + rs.getString(2));

				//System.out.println("description=" + rs.getString(3));
				//System.out.println("price=" + rs.getString(4));
				
				//System.out.println("\t");

			}
		//	r= r-1;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public static void main(String[] args) {
		Qq nn=new Qq();
		nn.Forquantity();
		
		//QuantityDecrease q=new QuantityDecrease();
		//q.Forquantity();
		
	}


}

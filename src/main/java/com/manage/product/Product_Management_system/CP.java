package com.manage.product.Product_Management_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	static Connection con;
	
	public static Connection createC() {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create the connection..
			String user ="root";
			String password="root123";
			String url ="jdbc:mysql://localhost:3306/product_manage_sys";
			con = DriverManager.getConnection(url,user,password);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
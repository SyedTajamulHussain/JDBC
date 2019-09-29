package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fetchingwholeTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String url ="jdbc:mysql://localhost:3306/fruitshop";
		String uname= "root";
		String Pass = "newrootpassword";
		
		String query = "SELECT * FROM Fruit;";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,Pass);
		Statement st =con.createStatement();
		ResultSet rs= st.executeQuery(query);
		
		while(rs.next()){
			String fruit =rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getInt(3);
			System.err.println(fruit);
		}

	}

}

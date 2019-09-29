package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insertingDataInDB {

	static String url ="jdbc:mysql://localhost:3306/fruitshop";
	static String uname= "root";
	static String Pass = "newrootpassword";
	static String query1 = "INSERT INTO Units VALUES (9,'ttttt','2015-02-15 10:30:00','2015-02-15 10:30:00');";
	static int UnitId  = 10;
	static String UnitName = "AAAA";
	static String DateEntered = "2019-02-15 10:30:00";
	static String	DateUpdated = "2019-02-15 10:30:00";
	static String query = "INSERT INTO Units VALUES (?,?,?,?)";
	
	public static void main(String[] args) throws Throwable {

		//insertingwithQuery();
		insertingwithpreparedQuery();
		}
	
		public static void insertingwithQuery () throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,Pass);
		Statement st =con.createStatement();
		int count = st.executeUpdate(query1);
		System.out.println(count + "Rows counted");
		
		st.close();
		con.close();
		
	}
	
	public static void insertingwithpreparedQuery () throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,Pass);
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1, UnitId);
		pr.setString(2 ,UnitName);
		pr.setString(3 ,DateEntered);
		pr.setString(4 ,DateUpdated);
		int count = pr.executeUpdate();
		
		System.out.println(count + "Rows counted");
		pr.close();
		con.close();
		
	}

}

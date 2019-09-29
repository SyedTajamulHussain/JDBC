package com.qa.jdbc;

import java.sql.*;

/*Steps :
1.  Import the package  : Java.sql package
2.	Load and register the driver
3.	Establish the connection
4.	Create the statement
5.	Execute the query 
6.	Process the results
7.	Close the connection
*/

public class fetchingSingleValueFromDB {
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String url ="jdbc:mysql://localhost:3306/fruitshop";
		String uname= "root";
		String Pass = "newrootpassword";
		
		String query = "SELECT FruitId, FruitName FROM Fruit;";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,Pass);
		Statement st =con.createStatement();
		ResultSet rs= st.executeQuery(query);
		
		rs.next();
		String Value= rs.getString("FruitName");
		System.out.println("single value " + Value);
		
		String fruitdetails =rs.getInt(1) + ": " + rs.getString(2);
		System.out.println("fetching first row of table "+ fruitdetails);
		
		
		
		
		st.close();
		con.close();
				

	}

}

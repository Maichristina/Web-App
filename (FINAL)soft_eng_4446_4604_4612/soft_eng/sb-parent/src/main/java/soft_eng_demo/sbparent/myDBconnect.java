package soft_eng_demo.sbparent;

import java.sql.*;
public class myDBconnect {

	public static void main(String[] args) {
		   try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/texnlog", "root", "123456");//Establishing connection
		System.out.println("Connected With the database successfully");
		//Creating PreparedStatement object
		PreparedStatement insertTostudent=connection.prepareStatement("insert into Student values(?,?,?,?)");
		//Setting values for Each Parameter
		insertTostudent.setInt(1,3456);
		insertTostudent.setString(2,"gfhhfds");
		insertTostudent.setString(3, "hjjhgfd");
		insertTostudent.setInt(4, 6);
		        
		         //Executing Query
		insertTostudent.executeUpdate();
	    PreparedStatement insertTogrades=connection.prepareStatement("insert into Grades values(?,?)");
		 		//Setting values for Each Parameter
	    insertTogrades.setInt(1,3);
	    insertTogrades.setDouble(2,2.4);
		 		        
		 		         //Executing Query
		insertTogrades.executeUpdate();
		System.out.println("data inserted successfully");
		} catch (SQLException e) {
		System.out.println("Error while connecting to the database");
		}
	}
}

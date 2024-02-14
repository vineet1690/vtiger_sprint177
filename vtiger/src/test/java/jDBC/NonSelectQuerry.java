package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class NonSelectQuerry {

	public static void main(String[] args) throws SQLException 
	{
		Driver dataBaseDriver = new Driver();
		
		DriverManager.registerDriver(dataBaseDriver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger2","root","root");
		
		int result = connection.createStatement().executeUpdate("insert into lead values(3,'laxman','Ayodhya');");
		
		if(result ==1)
		{
			System.out.println("the data base has been updated");
		}
		else
		{
			System.out.println("the data base has not been updated");
		}
		
		connection.close();
	}

}

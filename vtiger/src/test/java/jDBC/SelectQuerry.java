package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class SelectQuerry {

	public static void main(String[] args) throws SQLException 
	{
		//My sql instance ie object created
		Driver dataBaseDriver = new Driver();
		//jdbc or java Register with my sql
		DriverManager.registerDriver(dataBaseDriver);
		//connection establish
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger2","root","root");
		//querry pass
		ResultSet result = connection.createStatement().executeQuery("select * from lead;");
		//result print kiya
		while(result.next())
		{
			System.out.println(result.getString(1));
		}
		connection.close();

	}

}

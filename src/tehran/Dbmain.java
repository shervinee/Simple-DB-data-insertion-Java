package tehran;

import java.sql.*;
public class Dbmain {
	public static void main(String [] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","amirsam","myjava123");
		Statement statement = connection.createStatement();
		int i = statement.executeUpdate("delete from person where id = 3");
		System.out.println(i);
		statement.close();
		connection.close();
	}
	
	public static void main1(String [] args)throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = 
				DriverManager.getConnection("jdb:.oracle:thin:@localhost:1521:orcl","amirsam","myjava123");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from person");
		
		while(resultSet.next()){
			System.out.println(resultSet.getString("id"));
			System.out.println(resultSet.getString("name"));
			System.out.println(resultSet.getString("family"));
		}
		statement.close();
		connection.close();
	}

}

package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InstertCommand extends DbManager{

	public static void main(String[] args) throws SQLException {
		

		
		Connection con = setUpMysqlConnection();
		
		if(!con.isClosed()) {
			System.out.println("Connection is succesfull");
		}
		
		Statement st = con.createStatement();
		
		//String query = "insert into dbcon values(null,'sidhh','5864657456')";
		
		int num=100;
		
		for(int i=0;i<num;i++) {
			
			String query = "insert into dbcon values(null,'Madgaonkar',"+i+")";
			
			if(st.execute(query)){
				
				System.out.println("query execution failed");
			}else {
				System.out.println("query executed");
			}
			
		}
		
		
		

	}
}
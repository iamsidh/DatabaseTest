package database_connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImages extends DbManager {
	
	/*
	 * Create table 
	 * 
	 * create table images(id int primary key auto_increment , pic blob );
	 * 
	 * blob datatype for binary large objects
	 * 
	 * max for blob is 64kb size image/doc
	 * for images max 16mb i used mediumblob
	 * and for the files more than 16mb till 4gb there is longblob to use
	 */

	public static void main(String[] args) throws SQLException, IOException {

		try {

			Connection con = setUpMysqlConnection();

			String q = "insert into images(pic)values(?)";

			PreparedStatement pstmt = con.prepareStatement(q);

			FileInputStream fis = new FileInputStream("./src/main/java/database_connection/tree.jpg");

			pstmt.setBinaryStream(1, fis, fis.available());

			pstmt.executeUpdate();

			System.out.println("Pic inserted");
			
		} catch (Exception e) {

			System.out.println("Error occured");
			
			System.out.println(e.getMessage());
		}
	}

}

package database_connection;

import java.sql.SQLException;;

public class TestDatabase extends DbManager {

	public static void main(String[] args) throws SQLException {

		String query = "select * from dbcon";

		// String query= "select * from dbcon where id=3";

		setUpMysqlConnection();

		getSqlQuery(query);
		
	}

}
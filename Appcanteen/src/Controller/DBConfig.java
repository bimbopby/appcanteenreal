package Controller;

import java.sql.*;

public class DBConfig {
	public static Connection con;
	
	public DBConfig(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:8081/canteen_kma?zeroDateTimeBehavior=CONVERT_TO_NULL";
			String dbClass = "com.mysql.jdbc.Driver";

			try {
				//Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, "root", "123@qaz");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

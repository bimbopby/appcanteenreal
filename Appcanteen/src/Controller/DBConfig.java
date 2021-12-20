package Controller;

import java.sql.*;

public class DBConfig {
	public static Connection con;
	
	public DBConfig(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3307/canteenreal?zeroDateTimeBehavior=CONVERT_TO_NULL";
			String dbClass = "com.mysql.jdbc.Driver";

			try {
				//Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, "root", "1092000");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

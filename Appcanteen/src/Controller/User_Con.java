package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.User;


public class User_Con extends DBConfig{
	
	public User_Con() {
            super();
	}
	
	public int checkLogin(User user) {
                int classify = 0;
		String sql = "SELECT user_name, user_type FROM user WHERE user_name = ? AND user_pass = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setUsername(rs.getString("user_name"));
				user.setUser_type(rs.getInt("user_type"));
                                classify = 1;
			}                                             
		}catch(Exception e) {
			e.printStackTrace();
		}
		return classify;
	}
}

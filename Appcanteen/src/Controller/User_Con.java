package Controller;

import static Controller.DBConfig.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.User;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;


public class User_Con extends DBConfig{
	
	public User_Con() {
            super();
	}
	
	public boolean checkLogin(String username, String mk) {
             
		String sql = "SELECT user_name,name,user_type FROM user WHERE user_name = ? AND user_pass = ?";
		User user = null;
                
                try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, mk);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
                                user = new User();
                                user.setUsername(rs.getString("user_name"));
                                
				user.setName(rs.getString("name"));
                                user.setUser_type(rs.getInt("user_type"));
                                return true;
			}                                             
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
        public User Layin4(String username, String mk) {
             
		String sql = "SELECT user_name,name,user_type FROM user WHERE user_name = ? AND user_pass = ?";
		User user = null;
                
                try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, mk);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
                                user = new User();
                                user.setUsername(rs.getString("user_name"));
                                
				user.setName(rs.getString("name"));
                                user.setUser_type(rs.getInt("user_type"));
                               
			}                                             
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
         public boolean DoiMK(String username, String mk){
        String sql = "update user set user_pass = ? where user_name = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, mk);
            ps.setString(2, username);
            
            return ps.executeUpdate()>0;

            
        } catch (SQLException ex) {
           Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

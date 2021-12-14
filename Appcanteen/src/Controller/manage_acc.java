/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;
import Model.User;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class manage_acc extends DBConfig {

    public manage_acc() {
        super();
    }

    public ArrayList<User> getListUser() {
        ArrayList<User> lst = new ArrayList<>();
        String sql = "select * from user";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("id"));
                s.setUsername(rs.getString("user_name"));
                s.setPassword(rs.getString("user_pass"));
                s.setName(rs.getString("name"));
                s.setUser_type(rs.getString("user_type"));
                s.setGt(rs.getString("gt"));
                s.setNamsinh(rs.getInt("namsinh"));
                s.setPhone(rs.getInt("phone"));

                lst.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

}

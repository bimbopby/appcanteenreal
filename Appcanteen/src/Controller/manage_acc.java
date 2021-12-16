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
                s.setUser_type(rs.getInt("user_type"));
                s.setGt(rs.getInt("gt"));
                s.setNamsinh(rs.getString("namsinh"));
                s.setPhone(rs.getInt("phone"));

                lst.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
        public boolean addUser(User user){
        String sql = "insert into user(user_name, user_pass, name, user_type, gt,namsinh, phone)"+ "values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getUser_type());
            ps.setInt(5, user.getGt());
            ps.setString(6, user.getNamsinh());
            ps.setInt(7, user.getPhone());
            return ps.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    public boolean EditUser(User user){
        String sql = "update user set user_name = ?, user_pass = ?, name = ?, user_type= ?, gt = ?,namsinh = ?, phone = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getUser_type());
            ps.setInt(5, user.getGt());
            ps.setString(6, user.getNamsinh());
            ps.setInt(7, user.getPhone());
            return ps.executeUpdate()>0;

            
        } catch (SQLException ex) {
           Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
//    public User detailUser(User user){
//        String sql = "select id_pro,name_pro, unit, price, supplier,quantity from product where id_pro=?"; 
//        SanPham s = null;
//        try {
//           
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, sp_id);  
//            ResultSet rs = ps.executeQuery();
//           
//            while(rs.next()){
//                s  = new SanPham();
//                s.setProductID(rs.getString("id_pro"));
//                s.setNameSP(rs.getString("name_pro"));
//                s.setUnit(rs.getString("unit"));
//                s.setPrice(rs.getDouble("price"));
//                s.setNCC(rs.getString("supplier"));
//                s.setSoluong(rs.getInt("quantity"));    
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      return s;
//    }   
     public boolean XoaUser(String mauser){
        String sql = "delete from user where id= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mauser);
            return ps.executeUpdate() > 0;
                      
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

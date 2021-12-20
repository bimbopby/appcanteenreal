/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;
import Model.User;

import Model.User;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Administrator
 */
public class NhanVien_Con extends DBConfig {
     public NhanVien_Con() {
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
                s.setId(rs.getString("id"));
                s.setUsername(rs.getString("user_name"));
                s.setPassword(rs.getString("user_pass"));
                s.setName(rs.getString("name"));
                s.setUser_type(rs.getInt("user_type"));
                s.setGt(rs.getInt("gt"));
                s.setNamsinh(rs.getString("namsinh"));
                s.setPhone(rs.getInt("phone"));
                Blob blob = rs.getBlob("img");
                if (blob!= null) {
                        s.setImg(blob.getBytes(1, (int)blob.length()));
                } 
                lst.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
       
       
         public boolean addUser(User user){
        String sql = "insert into user(user_name, user_pass, name, user_type, gt,namsinh, phone,img,id)"+ "values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getUser_type());
            ps.setInt(5, user.getGt());
            ps.setString(6, user.getNamsinh());
            ps.setInt(7, user.getPhone());
             
            if (user.getImg()!=null) {
                Blob hinh  = new SerialBlob(user.getImg());
                ps.setBlob(8, hinh);
            } else{
                Blob hinh = null;
                ps.setBlob(8, hinh);
            }
            ps.setString(9, user.getId());
            
            return ps.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
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

        public boolean EditUser(User user){
        String sql = "update user set user_name = ?, user_pass = ?, name = ?, user_type= ?, gt = ?,namsinh = ?, phone = ?, img=? where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getUser_type());
            ps.setInt(5, user.getGt());
            ps.setString(6, user.getNamsinh());
            ps.setInt(7, user.getPhone());
            
            if (user.getImg()!=null) {
                Blob hinh  = new SerialBlob(user.getImg());
                ps.setBlob(8, hinh);
            } else{
                Blob hinh = null;
                ps.setBlob(8, hinh);
            }
            ps.setString(9, user.getId());
            
            return ps.executeUpdate()>0;

            
        } catch (SQLException ex) {
           Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public User detailUser(String manv){
        String sql = "select * from user where id =?";
        User s= null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
          
          
            ps.setString(1, manv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {               
                s = new User();
                s.setId(rs.getString("id"));
                s.setUsername(rs.getString("user_name"));
                s.setPassword(rs.getString("user_pass"));
                s.setName(rs.getString("name"));
                s.setUser_type(rs.getInt("user_type"));
                s.setGt(rs.getInt("gt"));
                s.setNamsinh(rs.getString("namsinh"));
                s.setPhone(rs.getInt("phone"));
                Blob blob = rs.getBlob("img");
                if (blob!= null) {
                        s.setImg(blob.getBytes(1, (int)blob.length()));
                } 
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}

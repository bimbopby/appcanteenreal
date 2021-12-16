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
     
       public ArrayList<User> getListNV(){
        ArrayList<User> lst = new ArrayList<>();
       String sql = "select * from product" ;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User s = new User();
                s.setId(rs.getInt("id"));
                s.setUsername(rs.getString("user_name"));
                s.setPassword(rs.getString("user_pass"));
                s.setUser_type(rs.getString("user_type"));
                s.setName(rs.getString("full_name"));
                s.setPhone(rs.getInt("phone"));
                s.setNamsinh(rs.getInt("yob"));
                s.setGt(rs.getInt("sex"));
                s.setImg(img);
                lst.add(s);

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
       
       
       public boolean addSP(User sp){
        String sql = "insert into user(id, user_name, user_pass, user_type, full_name, phone, yob, sex, img)"+ "values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sp.getId());
            ps.setString(2, sp.getUsername());
            ps.setString(3, sp.getPassword());
            ps.setString(4, sp.getUser_type());
            ps.setString(5, sp.getName());
            ps.setInt(6, sp.getPhone());
            ps.setInt(7, sp.getNamsinh());
            ps.setInt(8, sp.getGt());
            if (sp.getImg() != null) {
                Blob hinh = new SerialBlob(sp.getImg());
                ps.setBlob(9, hinh);
            } else {
                Blob hinh = null;
                ps.setBlob(9, hinh);
            }
              
            return ps.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

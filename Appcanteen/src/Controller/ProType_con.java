/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LoaiSP;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ProType_con extends DBConfig{

    public ProType_con() {
        super();
    }
      public boolean addLSP(LoaiSP sp){
        String sql = "insert into pro_type(id, name)"+ "values (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getId());
            ps.setString(2, sp.getName());
        
            return ps.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean EditLSP(LoaiSP sp){
        String sql = "update pro_type set name=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, sp.getId());
            ps.setString(1, sp.getName());
         
            return ps.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean XoaLSP(String masp){
        String sql = "delete from pro_type where id= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, masp);
            return ps.executeUpdate() > 0;
                      
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      public ArrayList<LoaiSP> getListLoaiSP(){
        ArrayList<LoaiSP> lst = new ArrayList<>();
       String sql = "select * from pro_type" ;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LoaiSP s = new LoaiSP();
                s.setId(rs.getString("id"));
                s.setName(rs.getString("name"));
              
                lst.add(s);

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    public LoaiSP cbxgetListLoaiSP(){
       
       String sql = "select * from pro_type" ;
        LoaiSP s=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
           
                s = new LoaiSP();
                s.setId(rs.getString("id"));
                s.setName(rs.getString("name"));
              

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
    return s;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;
import Model.HoaDon;
import Model.HoaDon;
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
public class HoaDon_con extends DBConfig{

    public HoaDon_con() {
        super();
    }
 
    public ArrayList<HoaDon> getListSanPham(){
        ArrayList<HoaDon> lst = new ArrayList<>();
       String sql = "select * from bill" ;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDon s = new HoaDon();
             
                s.setMaSP(rs.getString("masanpham"));
                s.setThanhtien(rs.getString("thanhtien"));
            
                s.setSoluong(rs.getInt("soluong"));
                lst.add(s);

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
    
    
    
    
    public HoaDon checkHD(){
       
        String sql = "select * from bill";
        HoaDon s = null;
        try {
           
            PreparedStatement ps = con.prepareStatement(sql);
         
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
             
                
                s  = new HoaDon();
                s.setMaSP(rs.getString("masanpham"));
                s.setSoluong(rs.getInt("soluong"));
                s.setThanhtien(rs.getString("thanhtien"));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
      return s;

    }
    
    public int countRow(){
       
        String sql = "select count(*) from bill";
        int row = 0;
        try {
           
            PreparedStatement ps = con.prepareStatement(sql);
         
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                 row = rs.getInt("count(*)");
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    
    
    public boolean addHD(HoaDon sp){
        String sql = "insert into bill(masanpham, soluong, thanhtien)"+ "values (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, sp.getMaSP());
            ps.setInt(2, sp.getSoluong());
            ps.setString(3, sp.getThanhtien());
        
            return ps.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
   public void deleteIn4(){
        String sql = "delete from bill";
         try {
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.executeUpdate() ;
                      
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}

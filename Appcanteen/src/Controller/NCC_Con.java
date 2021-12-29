/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;
import Model.NCC;
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
public class NCC_Con extends DBConfig{

    public NCC_Con() {
        super();
    }
      
    
    
    public boolean addNCC(NCC sp){
        String sql = "insert into ncc(id, name,phone,diachi)"+ "values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getId());
            ps.setString(2, sp.getName());
            ps.setString(3, sp.getSdt());
            ps.setString(4, sp.getDiachi());
            return ps.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(NCC_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean EditNCC(NCC sp){
        String sql = "update ncc set name=?, phone=?, diachi=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(4, sp.getId());
            ps.setString(3, sp.getDiachi());
            ps.setString(2, sp.getSdt());
            ps.setString(1, sp.getName());
         
            return ps.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(NCC_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean XoaNCC(String masp){
        String sql = "delete from ncc where id= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, masp);
            return ps.executeUpdate() > 0;
                      
            
        } catch (SQLException ex) {
            Logger.getLogger(NCC_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      public ArrayList<NCC> getListNCC(){
        ArrayList<NCC> lst = new ArrayList<>();
       String sql = "select * from ncc" ;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NCC s = new NCC();
                s.setId(rs.getString("id"));
                s.setName(rs.getString("name"));
                s.setSdt(rs.getString("phone"));
                s.setDiachi(rs.getString("diachi"));
                lst.add(s);

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(NCC_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
}

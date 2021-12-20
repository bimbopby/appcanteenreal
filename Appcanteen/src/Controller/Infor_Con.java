/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;
import Model.In4;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Infor_Con extends DBConfig{

    public Infor_Con() {
        super();
    }
    public void deleteIn4(){
        String sql = "delete from infor";
         try {
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.executeUpdate() ;
                      
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addin4(In4 sp){
        String sql = "insert into bill(id, sanpham, soluong, thanhtien)"+ "values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getId());
            ps.setString(2, sp.getSP());
            ps.setInt(3, sp.getSoluong());
            ps.setString(4, sp.getThanhtien());
        
            return ps.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

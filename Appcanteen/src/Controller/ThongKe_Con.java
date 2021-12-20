/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;

import Model.ThongKe;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ThongKe_Con extends DBConfig{

    
    
    public ThongKe_Con() {
        super();
    }
    public void addTK(ThongKe sp){
        String sql = "insert into thongke(tennv, ngay, gio , tonghd, tiennhan,tienthua)"+ "values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getName());
            ps.setString(2, sp.getDate());
            ps.setString(3, sp.getTime());
            ps.setString(4, sp.getTotalMoney());
            ps.setString(5, sp.getMoney());
            ps.setString(6, sp.getSurplus());
             ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
}

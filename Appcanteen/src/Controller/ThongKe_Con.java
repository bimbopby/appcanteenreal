/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;

import Model.ThongKe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "insert into thongke(tennv, ngay, gio , tonghd, tiennhan, tienthua, mahd, pay_method)"+ "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getName());
            ps.setString(2, sp.getDate());
            ps.setString(3, sp.getTime());
            ps.setString(4, sp.getTotalMoney());
            ps.setString(5, sp.getMoney());
            ps.setString(6, sp.getSurplus());
            ps.setString(7, sp.getMaHD());
            ps.setString(8, sp.getPay_method());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   public int countRow(){
       
        String sql = "select count(*) from thongke";
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
}

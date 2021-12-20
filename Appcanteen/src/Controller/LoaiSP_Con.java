/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;
import Model.LoaiSP;
import Model.SanPham;
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
public class LoaiSP_Con extends DBConfig{

    public LoaiSP_Con() {
        super();
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
    
    
    
    
}

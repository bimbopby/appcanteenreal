/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;
import Model.Revenue;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class Revenue_Con extends DBConfig {
    public Revenue_Con() {
        super();
    }
    public ArrayList<Revenue> getListRevenue() {
        ArrayList<Revenue> lst = new ArrayList<>();
        String sql = "select * from revenue";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Revenue s= new Revenue();
                s.setName(rs.getString("name"));
                s.setDate(rs.getString("date"));
                s.setTotal_monney(rs.getString("total_money"));
                s.setMonney(rs.getString("money"));
                s.setSurplus(rs.getString("surplus"));
                s.setTime(rs.getString("time"));
                lst.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Revenue_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
        public ArrayList<Revenue> getListRevenue_query(String sql) {
        ArrayList<Revenue> lst = new ArrayList<>();
//        String sql = "select * from revenue";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Revenue s= new Revenue();
                s.setName(rs.getString("name"));
                s.setDate(rs.getString("date"));
                s.setTotal_monney(rs.getString("total_money"));
                s.setMonney(rs.getString("money"));
                s.setSurplus(rs.getString("surplus"));
                s.setTime(rs.getString("time"));
                lst.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Revenue_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

        
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DBConfig.con;

import Model.ThongKe;
import Model.stat;
import Model.stat2;
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
   
   
       public ArrayList<ThongKe> getListTK() {
        ArrayList<ThongKe> lst = new ArrayList<>();
        String sql = "select * from thongke";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe s= new ThongKe();
                s.setMaHD(rs.getString("mahd"));
                s.setName(rs.getString("tennv"));
                s.setDate(rs.getString("ngay"));
                s.setTime(rs.getString("gio"));
                s.setTotalMoney(rs.getString("tonghd"));
                s.setMoney(rs.getString("tiennhan"));
                s.setSurplus(rs.getString("tienthua"));
            
                lst.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Revenue_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
          
    private long convertedToNumbers(String s){
        String number="";
        String []array=s.replace(","," ").split("\\s");
        for(String i:array){
            number=number.concat(i);
        }
        return Long.parseLong(number);
    }
       
       public int tontien(){
           int tt= 0;
           String sql = "select * from thongke";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String []s=rs.getString("tonghd").trim().split("\\s");
                tt=(int) (convertedToNumbers(s[0])+tt);
            
      
            }
        } catch (SQLException ex) {
            Logger.getLogger(Revenue_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           return tt;
       }
        public int tontiendate(String d1,String d2){
           int tt= 0;
           String sql = "select * from thongke where ngay between ? and ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d1);
            ps.setString(2, d2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String []s=rs.getString("tonghd").trim().split("\\s");
                tt=(int) (convertedToNumbers(s[0])+tt);
            
      
            }
        } catch (SQLException ex) {
            Logger.getLogger(Revenue_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           return tt;
       }
       public ArrayList<ThongKe> getListTKdate(String d1,String d2 ) {
        ArrayList<ThongKe> lst = new ArrayList<>();
        String sql = "select * from thongke where ngay between ? and ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d1);
            ps.setString(2, d2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe s= new ThongKe();
                s.setMaHD(rs.getString("mahd"));
                s.setName(rs.getString("tennv"));
                s.setDate(rs.getString("ngay"));
                s.setTime(rs.getString("gio"));
                s.setTotalMoney(rs.getString("tonghd"));
                s.setMoney(rs.getString("tiennhan"));
                s.setSurplus(rs.getString("tienthua"));
            
                lst.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Revenue_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
     public ArrayList<stat> getListstat() {
        ArrayList<stat> lst = new ArrayList<>();
        String sql = "SELECT ngay,count(*) FROM canteenreal.thongke group by ngay order by ngay";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stat s = new stat();
                s.setNgay(rs.getString("ngay"));
                s.setSoluong(rs.getInt("count(*)"));
               
                lst.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
      
      public ArrayList<stat2> getListstat2() {
        ArrayList<stat2> lst = new ArrayList<>();
        String sql = "SELECT ngay,sum(tonghd) FROM canteenreal.thongke group by ngay order by ngay";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stat2 s = new stat2();
                s.setNgay(rs.getString("ngay"));
                s.setTonghd(rs.getInt("sum(tonghd)"));
               
                lst.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
}

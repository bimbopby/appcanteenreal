/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class HoaDon {
    private String MaSP,thanhtien;
    private int soluong;

    public HoaDon( String MaSP, String thanhtien, int soluong) {
        
        this.MaSP = MaSP;
        this.thanhtien = thanhtien;
        this.soluong = soluong;
    }

    public HoaDon() {
    }

  
   
    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    
}

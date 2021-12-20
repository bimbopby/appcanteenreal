/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class Revenue_total implements Serializable {
    private String tungay, denngay;
    private String thonghoadon, tongtien;

    public Revenue_total(String tungay, String denngay, String thonghoadon, String tongtien) {
        this.tungay = tungay;
        this.denngay = denngay;
        this.thonghoadon = thonghoadon;
        this.tongtien = tongtien;
    }

    public String getTungay() {
        return tungay;
    }

    public void setTungay(String tungay) {
        this.tungay = tungay;
    }

    public String getDenngay() {
        return denngay;
    }

    public void setDenngay(String denngay) {
        this.denngay = denngay;
    }

    public String getThonghoadon() {
        return thonghoadon;
    }

    public void setThonghoadon(String thonghoadon) {
        this.thonghoadon = thonghoadon;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }


}

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
public class Revenue implements Serializable {
    private String date, name, time;
    private String total_monney, monney, surplus;
 
    public Revenue(){
    }
    public Revenue(String date, String name, String time, String total_monney, String monney, String surplus) {
        this.date = date;
        this.name = name;
        this.time = time;
        this.total_monney = total_monney;
        this.monney = monney;
        this.surplus = surplus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal_monney() {
        return total_monney;
    }

    public void setTotal_monney(String total_monney) {
        this.total_monney = total_monney;
    }

    public String getMonney() {
        return monney;
    }

    public void setMonney(String monney) {
        this.monney = monney;
    }

    public String getSurplus() {
        return surplus;
    }

    public void setSurplus(String surplus) {
        this.surplus = surplus;
    }


}

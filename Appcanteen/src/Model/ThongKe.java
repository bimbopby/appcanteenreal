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
public class ThongKe {
    private String Name,Date,Time,TotalMoney,Money,Surplus;

    public ThongKe(String Name, String Date, String Time, String TotalMoney, String Money, String Surplus) {
        this.Name = Name;
        this.Date = Date;
        this.Time = Time;
        this.TotalMoney = TotalMoney;
        this.Money = Money;
        this.Surplus = Surplus;
    }

    public ThongKe() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(String TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String Money) {
        this.Money = Money;
    }

    public String getSurplus() {
        return Surplus;
    }

    public void setSurplus(String Surplus) {
        this.Surplus = Surplus;
    }
    
    
    

}

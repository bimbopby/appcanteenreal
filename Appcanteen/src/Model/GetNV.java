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
public class GetNV {
   private String user;
    private String name;
    
    public GetNV(){
        user="dts1";
        name="Điện Tử Số 1";
    }
    
    public GetNV(String us, String na){
        this.user=us;
        this.name=na;
    }

    public GetNV(GetNV detail){
        this.user=detail.user;
        this.name=detail.name;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 
}

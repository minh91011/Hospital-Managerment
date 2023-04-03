/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Med {

    String med_id, name;
    Date NSX;
    int available;
    float price, HICoverage;

    public Med(String med_id, String name, Date NSX, int available, float price, float HICoverage) {
        this.med_id = med_id;
        this.name = name;
        this.NSX = NSX;
        this.available = available;
        this.price = price;
        this.HICoverage = HICoverage;
    }

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNSX() {
        return NSX;
    }

    public void setNSX(Date NSX) {
        this.NSX = NSX;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getHICoverage() {
        return HICoverage;
    }

    public void setHICoverage(float HICoverage) {
        this.HICoverage = HICoverage;
    }

}

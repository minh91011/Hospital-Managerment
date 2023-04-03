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
public class Bill {
    String pa_id;
    float room_charge, med_charge;
    Date startDate, endDate;

    public Bill(String pa_id, float room_charge, float med_charge, Date startDate, Date endDate) {
        this.pa_id = pa_id;
        this.room_charge = room_charge;
        this.med_charge = med_charge;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPa_id() {
        return pa_id;
    }

    public void setPa_id(String pa_id) {
        this.pa_id = pa_id;
    }

    public float getRoom_charge() {
        return room_charge;
    }

    public void setRoom_charge(float room_charge) {
        this.room_charge = room_charge;
    }

    public float getMed_charge() {
        return med_charge;
    }

    public void setMed_charge(float med_charge) {
        this.med_charge = med_charge;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    
}

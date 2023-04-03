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
public class Prescription {

    String pa_id, med_id;
    Date time;

    public Prescription(String pa_id, String med_id, Date time) {
        this.pa_id = pa_id;
        this.med_id = med_id;
        this.time = time;
    }

    public String getPa_id() {
        return pa_id;
    }

    public String getMed_id() {
        return med_id;
    }

    public Date getTime() {
        return time;
    }

    public void setPa_id(String pa_id) {
        this.pa_id = pa_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
}

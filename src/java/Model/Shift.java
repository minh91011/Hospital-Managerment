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
public class Shift {
    String nu_id,room_id;
    char shift;
    Date date;

    public Shift(String nu_id, String room_id, char shift, Date date) {
        this.nu_id = nu_id;
        this.room_id = room_id;
        this.shift = shift;
        this.date = date;
    }

    public String getNu_id() {
        return nu_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public char getShift() {
        return shift;
    }

    public Date getDate() {
        return date;
    }

    public void setNu_id(String nu_id) {
        this.nu_id = nu_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public void setShift(char shift) {
        this.shift = shift;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}

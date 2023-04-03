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
public class Doctor {
    String doc_id,fullName,address;
    boolean gender;
    Date birthDay;

    public Doctor(String doc_id, String fullName, String address, boolean gender, Date birthDay) {
        this.doc_id = doc_id;
        this.fullName = fullName;
        this.address = address;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public boolean isGender() {
        return gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    
}

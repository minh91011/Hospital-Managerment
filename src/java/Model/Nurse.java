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
public class Nurse {

    String nu_id, fullName, address;
    Date birthDay;
    boolean gender;

    public Nurse(String nu_id, String fullName, String address, Date birthDay, boolean gender) {
        this.nu_id = nu_id;
        this.fullName = fullName;
        this.address = address;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public String getNu_id() {
        return nu_id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setNu_id(String nu_id) {
        this.nu_id = nu_id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

}

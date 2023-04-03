/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DoctorDAO extends MyDAO {

    public List<Doctor> getDoctors() {
        List<Doctor> t = new ArrayList<>();
        xSql = "select * from Doctors order by Doc_id asc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xDoc_id, xFullName, xAddress;
            boolean xGender;
            Date xBirthDay;
            Doctor x;
            while (rs.next()) {
                xDoc_id = rs.getString("Doc_id");
                xFullName = rs.getString("FullName");
                xBirthDay = rs.getDate("BirthDay");
                xGender = rs.getBoolean("gender");
                xAddress = rs.getString("address");
                x = new Doctor(xDoc_id, xFullName, xAddress, xGender, xBirthDay);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Doctor getDoctor(String xDoc_id) {
        xSql = "select * from Doctors where Doc_id ='" + xDoc_id + "'";
        Doctor x = null;
        String xFullName, xAddress;
        boolean xGender;
        Date xBirthDay;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xFullName = rs.getString("FullName");
                xBirthDay = rs.getDate("BirthDay");
                xGender = rs.getBoolean("gender");
                xAddress = rs.getString("address");
                x = new Doctor(xDoc_id, xFullName, xAddress, xGender, xBirthDay);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public List<Doctor> getDoctorsName(String xxName) {
        List<Doctor> t = new ArrayList<>();
        xSql = "select * from Doctors WHERE FullName like '%" + xxName + "%'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xDoc_id, xFullName, xAddress;
            boolean xGender;
            Date xBirthDay;
            Doctor x;
            while (rs.next()) {
                xDoc_id = rs.getString("Doc_id");
                xFullName = rs.getString("FullName");
                xBirthDay = rs.getDate("BirthDay");
                xGender = rs.getBoolean("gender");
                xAddress = rs.getString("address");
                x = new Doctor(xDoc_id, xFullName, xAddress, xGender, xBirthDay);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Patient> getPatientsFromDoctor(String xDoc_id) {
        List<Patient> t = new ArrayList<>();
        xSql = "select * from Patients where Doc_id = '" + xDoc_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xPa_id, xFullName, xAddress;
            Date xBirthday;
            boolean xGender, xOutPatient, xHealthInsurance;
            Patient x;
            while (rs.next()) {
                xPa_id = rs.getString(1);
                xFullName = rs.getString(2);
                xBirthday = rs.getDate(3);
                xGender = rs.getBoolean(4);
                xAddress = rs.getString(5);
                xOutPatient = rs.getBoolean(6);
                xHealthInsurance = rs.getBoolean(7);
                xDoc_id = rs.getString(8);
                x = new Patient(xPa_id, xDoc_id, xFullName, xAddress, xBirthday, xGender, xOutPatient, xHealthInsurance);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void deleteDoctor(String doc_id) {
        xSql = "execute removeDoctor '" + doc_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String doc_id, String fullName, String birthday, String gender, String address) {
        xSql = "execute addDoctor '" + doc_id + "', '" + fullName + "', '" + birthday + "', " + gender + ", '" + address + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String doc_id, String fullName, String birthday, String gender, String address) {
        xSql = "update Doctors set FullName = '" + fullName + "', BirthDay ='" + birthday + "', gender = " + gender + ", address='" + address + "' where Doc_id = '" + doc_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

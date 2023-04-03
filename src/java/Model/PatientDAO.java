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
public class PatientDAO extends MyDAO {

    public List<Patient> getPatients() {
        List<Patient> t = new ArrayList<>();
        xSql = "select * from Patients order by Pa_id asc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xPa_id, xDoc_id, xFullName, xAddress;
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

    public List<Patient> getPatientsName(String xxName) {
        List<Patient> t = new ArrayList<>();
        xSql = "select * from Patients WHERE FullName like '%" + xxName + "%'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xPa_id, xDoc_id, xFullName, xAddress;
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

    public Patient getPatientId(String xPa_id) {
        Patient x = null;
        xSql = "select * from Patients where Pa_id = '" + xPa_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xDoc_id, xFullName, xAddress;
            Date xBirthday;
            boolean xGender, xOutPatient, xHealthInsurance;
            while (rs.next()) {
                xFullName = rs.getString(2);
                xBirthday = rs.getDate(3);
                xGender = rs.getBoolean(4);
                xAddress = rs.getString(5);
                xOutPatient = rs.getBoolean(6);
                xHealthInsurance = rs.getBoolean(7);
                xDoc_id = rs.getString(8);
                x = new Patient(xPa_id, xDoc_id, xFullName, xAddress, xBirthday, xGender, xOutPatient, xHealthInsurance);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public List<Prescription> getPrescriptionFromPatient(String xPa_id) {
        List<Prescription> t = new ArrayList<>();
        xSql = "select * from prescription where Pa_id = '" + xPa_id + "' order by Time asc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xMed_id;
            Date xTime;
            Prescription x;
            while (rs.next()) {
                xMed_id = rs.getString("Med_id");
                xTime = rs.getDate("Time");
                x = new Prescription(xPa_id, xMed_id, xTime);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public String getRoomFromPatient(String xPa_id) {
        String xRoom_id = null;
        xSql = "select * from InPatient where Pa_id = '" + xPa_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            while (rs.next()) {
                xRoom_id = rs.getString("Room_id");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xRoom_id;
    }

    public void deletePatient(String pa_id) {
        xSql = "execute removePatient '" + pa_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String pa_id, String fullName, String birthday, String gender, String address, String outPatient, String hI, String doc_id) {
        xSql = "execute addPatient'" + pa_id + "', '" + fullName + "', '" + birthday + "', " + gender + ", '" + address + "', " + outPatient + ", " + hI + ", '" + doc_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(String pa_id, String fullName, String birthday, String gender, String address, String outPatient, String hI, String doc_id){
        xSql = "update Patients set FullName = '"+fullName+"', BirthDay = '"+birthday+"', gender = "+gender+", address ='"+address+"', outPatient = "+outPatient+", HealthInsurance = "+hI+", Doc_id='"+doc_id+"' where Pa_id = '"+pa_id+"'";
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

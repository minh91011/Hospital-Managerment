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
public class PrescriptionDAO extends MyDAO {

    public void insert(String pa_id, String med_id, String time) {
        xSql = "execute addPrescription '"+pa_id+"' ,'"+med_id+"' ,'"+time+"'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Prescription getPrescription(String xPa_id) {
        xSql = "select * from prescription where Pa_id ='" + xPa_id + "'";
        Prescription x = null;
        String xMed_id;
        Date xTime;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xMed_id = rs.getString("Med_id");
                xTime = rs.getDate("Time");
                x = new Prescription(xPa_id, xMed_id, xTime);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
}

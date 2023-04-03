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
public class InPatientDAO extends MyDAO {

    public List<InPatient> getInPatients() {
        List<InPatient> t = new ArrayList<>();
        xSql = "select * from InPatient order by Room_id asc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xPa_id, xRoom_id;
            InPatient x;
            while (rs.next()) {
                xPa_id = rs.getString("Pa_id");
                xRoom_id = rs.getString("Room_id");
                x = new InPatient(xPa_id, xRoom_id);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public InPatient getInPatient(String xRoom_id) {
        xSql = "select * from InPatient where Room_id ='" + xRoom_id + "'";
        InPatient x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xPa_id;
            while (rs.next()) {
                xPa_id = rs.getString("Pa_id");
                x = new InPatient(xPa_id, xRoom_id);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public InPatient havePatientId(String xPa_id) {
        xSql = "select * from InPatient where Pa_id ='" + xPa_id + "'";
        InPatient x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xRoom_id;
            while (rs.next()) {
                xPa_id = rs.getString("Pa_id");
                xRoom_id = rs.getString("Room_id");
                x = new InPatient(xPa_id, xRoom_id);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void insert(String pa_id, String room_id) {
        xSql = "execute addInpatient '" + pa_id + "','" + room_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void update(String pa_id, String room_id) {
        xSql = "update InPatient set Room_id = '" + room_id + "' where Pa_id = '" + pa_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

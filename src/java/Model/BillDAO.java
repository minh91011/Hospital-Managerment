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
public class BillDAO extends MyDAO {

    public Bill takeBill(String pa_id) {
        xSql = "select * from bills where Pa_id = '"+pa_id+"'";
        Bill x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xPa_id;
            float xRoom_charge, xMed_charge;
            Date xStartDate, xEndDate;
            
            while (rs.next()) {
                xPa_id = rs.getString("Pa_id");
                xRoom_charge = rs.getFloat("Room_Charge");
                xMed_charge = rs.getFloat("Med_Charge");
                xStartDate = rs.getDate("startDate");
                xEndDate = rs.getDate("endDate");
                x = new Bill(pa_id, xRoom_charge, xMed_charge, xStartDate, xEndDate);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
    
    public void createBill(String pa_id){
        xSql = "execute createBill '"+pa_id+"'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

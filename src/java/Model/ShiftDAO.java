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
public class ShiftDAO extends MyDAO {

    public List<Shift> getShifts() {
        List<Shift> t = new ArrayList<>();
        xSql = "select * from Shifts";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xNu_id, xRoom_id;
            char xShift;
            Date xDate;
            Shift x;
            while (rs.next()) {
                xNu_id = rs.getString("Nu_id");
                xRoom_id = rs.getString("Room_id");
                xDate = rs.getDate("Date");
                xShift = rs.getString("Shift").charAt(0);
                x = new Shift(xNu_id, xRoom_id, xShift, xDate);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Shift> getNurseIDShift(String xNu_id) {
        List<Shift> t = new ArrayList<>();
        xSql = "select * from Shifts where Nu_id = '" + xNu_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xRoom_id;
            char xShift;
            Date xDate;
            Shift x;
            while (rs.next()) {
                xRoom_id = rs.getString("Room_id");
                xDate = rs.getDate("Date");
                xShift = rs.getString("Shift").charAt(0);
                x = new Shift(xNu_id, xRoom_id, xShift, xDate);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);

    }

    public void insert(String nu_id, String room_id, String date, String shift) {
        xSql = "execute addShift '" + nu_id + "', '" + room_id + "', '" + date + "','" + shift + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

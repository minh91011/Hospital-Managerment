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
public class NurseDAO extends MyDAO {

    public Nurse getNurse(String xNu_id) {
        xSql = "select * from Nurses where Nu_id ='" + xNu_id + "'";
        Nurse x = null;
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
                x = new Nurse(xNu_id, xFullName, xAddress, xBirthDay, xGender);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public List<Nurse> getNurses() {
        List<Nurse> t = new ArrayList<>();
        xSql = "select * from Nurses order by Nu_id asc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xNu_id, xFullName, xAddress;
            boolean xGender;
            Date xBirthDay;
            Nurse x;
            while (rs.next()) {
                xNu_id = rs.getString("Nu_id");
                xFullName = rs.getString("FullName");
                xBirthDay = rs.getDate("BirthDay");
                xGender = rs.getBoolean("gender");
                xAddress = rs.getString("address");
                x = new Nurse(xNu_id, xFullName, xAddress, xBirthDay, xGender);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Nurse> getNursesName(String xxName) {
        List<Nurse> t = new ArrayList<>();
        xSql = "select * from Nurses WHERE FullName like '%" + xxName + "%'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xNu_id, xFullName, xAddress;
            boolean xGender;
            Date xBirthDay;
            Nurse x;
            while (rs.next()) {
                xNu_id = rs.getString("Nu_id");
                xFullName = rs.getString("FullName");
                xBirthDay = rs.getDate("BirthDay");
                xGender = rs.getBoolean("gender");
                xAddress = rs.getString("address");
                x = new Nurse(xNu_id, xFullName, xAddress, xBirthDay, xGender);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);

    }

    public void insert(String nu_id, String fullName, String birthday, String gender, String address) {
        xSql = "execute addNurse '" + nu_id + "', '" + fullName + "', '" + birthday + "', " + gender + ", '" + address + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNurse(String nu_id) {
        xSql = "execute removeNurse '" + nu_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String nu_id, String fullName, String birthday, String gender, String address) {
        xSql = "update Nurses set FullName = '" + fullName + "', BirthDay ='" + birthday + "', gender = " + gender + ", address='" + address + "' where Nu_id = '" + nu_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

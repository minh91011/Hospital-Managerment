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
public class MedDAO extends MyDAO {

    public List<Med> getMeds() {
        List<Med> t = new ArrayList<>();
        xSql = "select * from Medicine order by Med_id asc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xMed_id, xName;
            Date xNSX;
            int xAvailable;
            float xPrice, xHICoverage;
            Med x;
            while (rs.next()) {
                xMed_id = rs.getString("Med_id");
                xName = rs.getString("Med_name");
                xNSX = rs.getDate("NSX");
                xAvailable = rs.getInt("available");
                xPrice = rs.getFloat("price");
                xHICoverage = rs.getFloat("HealthInsuranceCoverage");
                x = new Med(xMed_id, xName, xNSX, xAvailable, xPrice, xHICoverage);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Med> getMedsName(String xxName) {
        List<Med> t = new ArrayList<>();
        xSql = "select * from Medicine WHERE Med_name like '%" + xxName + "%'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xMed_id, xName;
            Date xNSX;
            int xAvailable;
            float xPrice, xHICoverage;
            Med x;
            while (rs.next()) {
                xName = rs.getString("Med_name");
                xMed_id = rs.getString("Med_id");
                xNSX = rs.getDate("NSX");
                xAvailable = rs.getInt("available");
                xPrice = rs.getFloat("price");
                xHICoverage = rs.getFloat("HealthInsuranceCoverage");
                x = new Med(xMed_id, xName, xNSX, xAvailable, xPrice, xHICoverage);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Med getMedId(String xMed_id) {
        Med x = null;
        xSql = "select * from Medicine where Med_id = '" + xMed_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xName;
            Date xNSX;
            int xAvailable;
            float xPrice, xHICoverage;
            while (rs.next()) {
                xMed_id = rs.getString("Med_id");
                xName = rs.getString("Med_name");
                xNSX = rs.getDate("NSX");
                xAvailable = rs.getInt("available");
                xPrice = rs.getFloat("price");
                xHICoverage = rs.getFloat("HealthInsuranceCoverage");
                x = new Med(xMed_id, xName, xNSX, xAvailable, xPrice, xHICoverage);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void deleteMedicine(String med_id) {
        xSql = "execute removeMedicine '" + med_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String med_id, String name, String nsx, int available, float price, float healthInsuranceCoverage) {
        xSql = "execute addMedicine '" + med_id + "', '" + name + "' , '" + nsx + "'," + available + "," + price + "," + healthInsuranceCoverage;
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String med_id, String name, String nsx, int available, float price, float healthInsuranceCoverage) {
        xSql = "update Medicine set Med_name = '" + name + "', NSX = '" + nsx + "', available = " + available + ", price = " + price + ", HealthInsuranceCoverage = " + healthInsuranceCoverage + " where Med_id = '" + med_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

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
public class RoomDAO extends MyDAO {

    public List<Room> getRooms() {
        List<Room> t = new ArrayList<>();
        xSql = "select * from Rooms order by Room_id asc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xId, xType;
            int xAvailable;
            float xPricePerday;
            Room x;
            while (rs.next()) {
                xId = rs.getString("Room_id");
                xType = rs.getString("type");
                xAvailable = rs.getInt("available");
                xPricePerday = rs.getFloat("pricePerDay");
                x = new Room(xId, xType, xAvailable, xPricePerday);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Room getRoom(String xRoom_id) {
        xSql = "select * from Rooms where Room_id ='" + xRoom_id + "'";
        Room x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xId, xType;
            int xAvailable;
            float xPricePerday;
            while (rs.next()) {
                xId = rs.getString("Room_id");
                xType = rs.getString("type");
                xAvailable = rs.getInt("available");
                xPricePerday = rs.getFloat("pricePerDay");
                x = new Room(xId, xType, xAvailable, xPricePerday);
                rs.close();
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void deleteRoom(String room_id) {
        xSql = "execute removeRoom '" + room_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String room_id, String type, int available, float pricePerDay) {
        xSql = "update Rooms set type = '" + type + "', available = " + available + ", pricePerDay = " + pricePerDay + " where Room_id = '" + room_id + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String room_id, String type, int available, float pricePerDay) {
        xSql = "execute addRoom '"+room_id+"', '"+type+"', "+available+","+pricePerDay;
        try {
            ps = con.prepareStatement(xSql);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

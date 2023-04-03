package Model;

import java.util.ArrayList;
import java.util.List;

public class UserDAO extends MyDAO {

    public List<User> getUsers() {
        List<User> t = new ArrayList<>();
        xSql = "select * from Users";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xName, xPass;
            int xRole;
            User x;
            while (rs.next()) {
                xName = rs.getString("name");
                xPass = rs.getString("pass");
                xRole = rs.getInt("role");
                x = new User(xName, xPass, xRole);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public User getUser(String xName, String xPass) {
        xSql = "select * from Users where Name = '"+xName+"' and Pass = '"+xPass+"'";

        int xRole;
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            /* The cursor on the rs after this statement is in the BOF area, i.e. it is before the first record.
         Thus the first rs.next() statement moves the cursor to the first record
             */

            if (rs.next()) {
                xRole = rs.getInt("role");
                x = new User(xName, xPass, xRole);
            } else {
                x = null;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return (x);
    }

    public void deleteUser(String name) {
        xSql = "delete from Users where Name = '" + name + "'";
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String name, String pass, int role) {
        xSql = "insert into Users values ('"+name+"','"+pass+"',"+role+")";
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String name, String pass, int role) {
        xSql = "update Users set Pass = '"+pass+"', Role = "+role+" where Name ='"+name+"'";
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package Model;

public class User {
  private String name;
  private String pass;
  private int role;

    public User() {
    }

    public User(String name, String pass, int role) {
        this.name = name;
        this.pass = pass;
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public int getRole() {
        return role;
    }
  
}

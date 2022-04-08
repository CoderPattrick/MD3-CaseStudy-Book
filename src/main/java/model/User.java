package model;

public class User {
    private int id ;
    private String name;
    private String acc ;
    private String pass ;
    private boolean role;

    public User() {
    }

    public User(int id, String acc, String pass) {
        this.id = id;
        this.acc = acc;
        this.pass = pass;
    }

    public User(String acc, String pass) {
        this.acc = acc;
        this.pass = pass;
    }

    public User(int id, String name, String acc, String pass, boolean role) {
        this.id = id;
        this.name = name;
        this.acc = acc;
        this.pass = pass;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}


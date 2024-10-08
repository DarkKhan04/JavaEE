package kz.bitlab.techorda.db;

public class User {
    private Long id;
    private String full_name;
    private String email;
    private String password;
    private int role_id;

    public User() {
    }

    public User(Long id, String full_name, String email, String password) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

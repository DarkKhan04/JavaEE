package kz.bitlab.techorda.db;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private String instagram;

    public Author(int id, String firstName, String lastName, String instagram) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instagram = instagram;
    }

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}

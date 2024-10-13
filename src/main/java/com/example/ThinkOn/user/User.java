package com.example.ThinkOn.user;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id //primary key of the class
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize=1 // size of the integer
    )

    // primary key should be automatically generated
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    /**
     * The User will have an id
     */
    private Long id;

    /**
     * The User will have a username
     */
    private String username;

    /**
     * The User will have a first name
     */
    private String first_name;

    /**
     * The User will have a last name
     */
    private String last_name;

    /**
     * The User will have an email
     */
    private String email;

    /**
     * The User will have a phone number, this will serve as the identifier for this purpose since we do not directly have an Id field
     */
    private String phone;

    /**
     * Constructor without args
     */
    public User() {
    }

    /**
     * Constructor without the id
     */
    public User(String username, String first_name, String last_name, String email, String phone) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Constructor with all the arguments
     */
    public User(Long id, String username, String first_name, String last_name, String email, String phone) {
        this.id=id;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.last_name = last_name;
        this.first_name = first_name;
    }

    /**
     * The getters and setters for the arguments
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /** To String for the user (demo purposes) */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

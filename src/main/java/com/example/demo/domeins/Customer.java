package com.example.demo.domeins;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    private String firstname;
    private String lastname;
    private String middlename;
    private String mobileNumber;
    private String homeNumber;
    private String email;

    public Customer () {}

    public Customer (Integer id, String firstname, String lastname, String middlename,
                     String mobileNumber, String homeNumber, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.email = email;
    }

    public Customer (String firstname, String lastname, String middlename,
                     String mobileNumber, String homeNumber, String email) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

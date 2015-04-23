package com.daffodilsw.core.data.jpa.model;

import com.daffodilsw.core.data.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by user on 16/4/15.
 */
@Entity
@Table(name = "USER")
public class JpaUser extends JpaModelAuto implements User {

    private static final long serialVersionUID = -7131097387807386185L;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    private Boolean appAdmin;

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Boolean isAppAdmin() {
        return this.appAdmin;
    }

    public void setAppAdmin(Boolean appAdmin) {
        this.appAdmin = appAdmin;
    }
}

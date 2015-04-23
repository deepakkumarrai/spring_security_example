package com.daffodilsw.web.controller.endpoint.dto;

/**
 * Created by user on 23/4/15.
 */
public class ContactDto {

    private Long contactId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String userName;

    private String password;

    private Boolean appAdmin;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAppAdmin() {
        return appAdmin;
    }

    public void setAppAdmin(Boolean appAdmin) {
        this.appAdmin = appAdmin;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
}

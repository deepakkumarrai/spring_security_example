package com.daffodilsw.core.data.model;

/**
 * Created by user on 16/4/15.
 */
public interface User {

    String getUserName();

    String getPassword();

    String getEmail();

    String getPhoneNumber();

    String getFirstName();

    String getLastName();

    Boolean isAppAdmin();
}

package com.daffodilsw.web.security;

import com.daffodilsw.core.data.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 16/4/15.
 */
public class UserAuthentication implements Authentication {

    private String password;

    private User user;

    private boolean isAuthenticated;

    private Set<GrantedAuthority> authorities = new HashSet<>();

    private String userName;

    public UserAuthentication(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserAuthentication(User user) {
        this.user = user;
        this.password = user.getPassword();
        this.userName = user.getUserName();
        isAuthenticated = true;
        setRole(user);
    }

    private void setRole(User user) {
        this.authorities.add(new SimpleGrantedAuthority(Role.ROLE_USER.toString()));
        if (user.isAppAdmin()) {
            this.authorities.add(new SimpleGrantedAuthority(Role.ROLE_APP_ADMIN.toString()));
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public Object getDetails() {
        return this.user;
    }

    @Override
    public Object getPrincipal() {
        if (isAuthenticated) {
            return user;
        }
        return this.userName;
    }

    @Override
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Once created you cannot set this token to authenticated. Create a new instance using the constructor which takes a User class object will mark this as authenticated.");
        }
        this.isAuthenticated = false;
    }

    @Override
    public String getName() {
        return userName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserAuthentication) {
            return ((UserAuthentication) obj).userName.equals(this.userName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.userName.hashCode();
    }
}

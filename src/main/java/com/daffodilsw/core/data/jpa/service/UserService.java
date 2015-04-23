package com.daffodilsw.core.data.jpa.service;

import com.daffodilsw.core.data.model.User;

/**
 * Created by user on 17/4/15.
 */
public interface UserService {

    User getOneByPrincipleAndCredentials(String principle, String credentials);

}

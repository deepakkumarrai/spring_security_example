package com.daffodilsw.core.data.jpa.service;

import com.daffodilsw.core.data.model.UserConnection;

import java.util.List;

/**
 * Created by user on 23/4/15.
 */
public interface ContactService {
    List<UserConnection> listConnections(Long ownerId, int index, int pageSize);

    UserConnection save(UserConnection userConnection);

    Long delete(Long id);
}

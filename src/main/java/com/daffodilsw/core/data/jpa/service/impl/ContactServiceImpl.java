package com.daffodilsw.core.data.jpa.service.impl;

import com.daffodilsw.core.data.jpa.service.ContactService;
import com.daffodilsw.core.data.model.UserConnection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by user on 23/4/15.
 */
public class ContactServiceImpl implements ContactService {
    @Override
    public List<UserConnection> listConnections(Long ownerId, int index, int pageSize) {
        if (index < 0) {
            index = 0;
        }
        if (pageSize < 1) {
            pageSize = 20;
        }
        Pageable pageable = new PageRequest(index, pageSize);

        return null;
    }
}

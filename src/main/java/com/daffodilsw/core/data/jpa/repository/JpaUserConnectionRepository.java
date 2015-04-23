package com.daffodilsw.core.data.jpa.repository;

import com.daffodilsw.core.data.jpa.embed.ConnectionId;
import com.daffodilsw.core.data.jpa.model.JpaUserConnection;
import com.daffodilsw.core.data.model.UserConnection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by user on 23/4/15.
 */
public interface JpaUserConnectionRepository extends JpaRepository<JpaUserConnection, ConnectionId> {

    @Query("SELECT u from JpaUserConnection u where u.id.first = :ownerId")
    List<UserConnection> listConnection(@Param("ownerId") Long ownerId, Pageable pageable);
}

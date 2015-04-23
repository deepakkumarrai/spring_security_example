package com.daffodilsw.core.data.jpa.repository;

import com.daffodilsw.core.data.jpa.embed.ConnectionId;
import com.daffodilsw.core.data.jpa.model.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by user on 16/4/15.
 */
public interface JpaUserRepository extends JpaRepository<JpaUser, Long> {

    @Query("SELECT u.id from JpaUser u where u.id = :id")
    JpaUser findOneByUser(@Param("id") String id);


}

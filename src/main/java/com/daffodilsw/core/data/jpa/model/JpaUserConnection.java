package com.daffodilsw.core.data.jpa.model;

import com.daffodilsw.core.data.jpa.embed.ConnectionId;
import com.daffodilsw.core.data.model.User;
import com.daffodilsw.core.data.model.UserConnection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by user on 16/4/15.
 */
@Entity
@Table(name = "USER_CONNECTION")
public class JpaUserConnection extends JpaSerializable<ConnectionId> implements UserConnection {
    private static final long serialVersionUID = 5499024258321756248L;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "first", column = @Column(name = "`OWNER_ID`")),
            @AttributeOverride(name = "last", column = @Column(name = "`CONNECTION_ID`"))
    })
    private ConnectionId id;

    @ManyToOne(optional = false, targetEntity = JpaUser.class)
    @JoinColumn(name = "`OWNER_ID`", updatable = false, insertable = false)
    private User owner;

    @ManyToOne(optional = false, targetEntity = JpaUser.class)
    @JoinColumn(name = "`CONNECTION_ID`", updatable = false, insertable = false)
    private User connection;

    @Override
    public ConnectionId getId() {
        return id;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public User getConnection() {
        return connection;
    }

    public void setConnection(User connection) {
        this.connection = connection;
    }

}

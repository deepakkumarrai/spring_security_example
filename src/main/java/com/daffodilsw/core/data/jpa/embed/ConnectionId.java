package com.daffodilsw.core.data.jpa.embed;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by user on 16/4/15.
 */
@Embeddable
public class ConnectionId implements Serializable {
    @Column(name = "`FIRST_ID`", nullable = false)
    private Long first;

    @Column(name = "`LAST_ID`", nullable = false)
    private Long last;

    public Long getFirst() {
        return first;
    }

    public Long getLast() {
        return last;
    }

    public ConnectionId(Long first, Long last) {
        this.first = first;
        this.last = last;
    }

    public void setFirst(Long id) {
        this.first = id;
    }

    public void setLast(Long ownerId) {
        this.last = ownerId;
    }

    public ConnectionId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConnectionId)) return false;

        ConnectionId that = (ConnectionId) o;

        if (!first.equals(that.first)) return false;
        if (!last.equals(that.last)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + last.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.first + ":" + this.last;
    }
}

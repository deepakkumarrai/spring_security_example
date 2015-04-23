package com.daffodilsw.core.data.jpa.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by user on 16/4/15.
 */
@SuppressWarnings("serial")
@EntityListeners(
        AuditingEntityListener.class
)
@MappedSuperclass
abstract public class JpaModel<PK extends Serializable> extends JpaSerializable<PK> {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`CREATED_DATE`")
    @CreatedDate
    private Date createdDate;

    @Column(name = "`LAST_MODIFIED_DATE`")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastModifiedDate;

    public Date getCreatedDate() {
        return createdDate == null ? new Date(0) : createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate == null ? new Date(0) : createdDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
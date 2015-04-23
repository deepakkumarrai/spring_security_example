package com.daffodilsw.core.data.jpa.model;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by hoozecn.
 */
@MappedSuperclass
abstract public class JpaSerializable<PK extends Serializable> implements Serializable {
    abstract public PK getId();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JpaSerializable)) return false;

        JpaSerializable jpaSerializable = (JpaSerializable) o;

        if (!getId().equals(jpaSerializable.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}

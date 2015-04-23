package com.daffodilsw.core.data.jpa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by hoozecn.
 */
@MappedSuperclass
public abstract class JpaModelAuto extends JpaModel<Long> {
    @Id
    @GeneratedValue
    @Column(name = "`ID`")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }
}

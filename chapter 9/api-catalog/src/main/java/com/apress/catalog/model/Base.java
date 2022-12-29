package com.apress.catalog.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Base implements Serializable {

    private Long id;

    private Audit audit;

    private Long version;

    public Base(){}

    public Base(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void fillCreatedOn() {
        audit.setCreatedOn(LocalDateTime.now());
    }

    public void fillUpdatedOn() {
        audit.setUpdatedOn(LocalDateTime.now());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return Objects.equals(id, base.id) && Objects.equals(audit, base.audit) && Objects.equals(version, base.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, audit, version);
    }
}

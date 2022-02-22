package ru.social.network.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseEntityAudit extends BaseEntity implements Serializable {
//    private String createdBy;
//    private String updatedBy;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void setCreationDate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = LocalDateTime.now();
    }

}

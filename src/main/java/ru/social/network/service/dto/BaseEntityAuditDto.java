package ru.social.network.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseEntityAuditDto extends BaseEntityDto {
//    private String createdBy;
//    private String updatedBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

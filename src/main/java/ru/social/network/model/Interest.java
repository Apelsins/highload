package ru.social.network.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "interest")
@Data
@EqualsAndHashCode(callSuper = true)
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Interest extends BaseEntity {

    private static final long serialVersionUID = -8392030876356559625L;

    @NotNull
    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @ManyToMany(targetEntity = Questionnaire.class, mappedBy = "interests", cascade = {CascadeType.ALL})
    Set<Questionnaire> questionnaires;

}

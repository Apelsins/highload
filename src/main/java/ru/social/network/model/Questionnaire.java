package ru.social.network.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.social.network.constants.Constants;
import ru.social.network.constants.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "questionnaire")
@Data
@EqualsAndHashCode(callSuper = true)
public class Questionnaire extends BaseEntityAudit implements Serializable {
    private static final long serialVersionUID = -1651455950847533407L;

    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @JsonIgnore
    @NotNull
    //@Size(min = 60, max = 60)
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Size(max = 50)
    @Column(name = "city", length = 50)
    private String city;

    @ManyToMany(targetEntity = Interest.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "questionnaire_interest",
            joinColumns = @JoinColumn(name = "questionnaire_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    Set<Interest> interests;

}

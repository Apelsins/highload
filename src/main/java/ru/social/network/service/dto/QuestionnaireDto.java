package ru.social.network.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.social.network.model.Interest;
import ru.social.network.constants.Gender;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireDto extends BaseEntityAuditDto {

    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    @NotNull
    //@Size(min = 60, max = 60)
    private String password;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    private Integer age;

    private Gender gender;

    @Size(max = 50)
    private String city;

    Set<Interest> interests;
}

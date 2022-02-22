package ru.social.network.service.mapper;


import org.mapstruct.Mapper;
import ru.social.network.model.Questionnaire;
import ru.social.network.service.dto.QuestionnaireDto;

@Mapper(componentModel = "spring")
public interface QuestionnaireMapper {

    QuestionnaireDto toDto(Questionnaire questionnaire);

    Questionnaire toEntity(QuestionnaireDto questionnaireDto);
}

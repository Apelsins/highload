package ru.social.network.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.social.network.model.Questionnaire;
import ru.social.network.repository.QuestionnaireRepository;
import ru.social.network.service.dto.QuestionnaireDto;
import ru.social.network.service.mapper.QuestionnaireMapper;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    private final QuestionnaireMapper modelMapper;

    public QuestionnaireDto getQuestionnaireById(UUID id) {
        return modelMapper.toDto(questionnaireRepository.getById(id));
    }

    public QuestionnaireDto addQuestionnaire(QuestionnaireDto questionnaire) {
        Questionnaire save = questionnaireRepository.save(modelMapper.toEntity(questionnaire));
        return modelMapper.toDto(save);
    }

    public QuestionnaireDto updateQuestionnaire(QuestionnaireDto questionnaire) {
        Questionnaire save = questionnaireRepository.save(modelMapper.toEntity(questionnaire));
        return modelMapper.toDto(save);
    }

    public void deleteQuestionnaire(UUID id) {
        questionnaireRepository.deleteById(id);
    }
}

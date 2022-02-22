package ru.social.network.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.social.network.service.QuestionnaireService;
import ru.social.network.service.dto.QuestionnaireDto;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/questionnaire")
@RequiredArgsConstructor
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionnaireDto getQuestionnaire(@PathVariable("id") UUID id) {
        return questionnaireService.getQuestionnaireById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionnaireDto addUser(@RequestBody QuestionnaireDto questionnaire) {
        return questionnaireService.addQuestionnaire(questionnaire);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public QuestionnaireDto updateUser(@RequestBody QuestionnaireDto questionnaire) {
        return questionnaireService.updateQuestionnaire(questionnaire);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") UUID id) {
        questionnaireService.deleteQuestionnaire(id);
    }

    @PostMapping("/1")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser() {
        System.out.println("Hi");
    }
}

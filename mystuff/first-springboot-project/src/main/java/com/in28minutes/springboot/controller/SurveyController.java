package com.in28minutes.springboot.controller;


import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping(path = "/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyId){
        return surveyService.retrieveQuestions(surveyId);
    }

    @PostMapping(path = "/surveys/{surveyId}/questions")
    public ResponseEntity addQuestionsToSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion){
        Question question = surveyService.addQuestion(surveyId,newQuestion);

        if (question==null){
            return ResponseEntity.noContent().build(); //204
        }
        URI location =ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(question.getId()).toUri();

        return ResponseEntity.created(location).build(); //201

    }

    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveDetailsForQuestion(@PathVariable String surveyId,
                                             @PathVariable String questionId){
        return surveyService.retrieveQuestion(surveyId,questionId);

    }
}

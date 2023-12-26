package com.courseWorkQuestionAndAnswer.QuestionAndAnswer.controllers;

import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.models.Question;
import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {

        this.examinerService = examinerService;
    }

    @GetMapping("{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }

}

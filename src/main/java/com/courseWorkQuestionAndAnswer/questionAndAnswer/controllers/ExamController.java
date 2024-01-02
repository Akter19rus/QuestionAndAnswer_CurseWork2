package com.courseWorkQuestionAndAnswer.questionAndAnswer.controllers;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.service.ExaminerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
@RequiredArgsConstructor
@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerService examinerService;

    @GetMapping("{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }

}

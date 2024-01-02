package com.courseWorkQuestionAndAnswer.questionAndAnswer.controllers;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RequiredArgsConstructor
@RestController
@RequestMapping("/exam/java")
public class JavaController {
    public final QuestionService question1;

    @GetMapping()
    public Collection<Question> getAll() {
        return question1.getAll();
    }

    @GetMapping(path = "/add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return question1.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        Question i = new Question(question, answer);
        return question1.remove(i);
    }

    @GetMapping("/java/find")
    public Question findQuestion(@RequestParam String question) {
        return question1.find(question);
    }
}

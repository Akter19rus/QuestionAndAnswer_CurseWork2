package com.courseWorkQuestionAndAnswer.QuestionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.models.Question;

import java.util.Collections;

public interface QuestionService {
    Question add(String question, String answer);

    Question remove(Question question);

    Collections<Question> getAll();

    Question getRandomQuestion();
}

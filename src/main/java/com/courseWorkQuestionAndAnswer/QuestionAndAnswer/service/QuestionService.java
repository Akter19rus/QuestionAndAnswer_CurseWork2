package com.courseWorkQuestionAndAnswer.QuestionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.models.Question;

import java.util.List;

public interface QuestionService {
    Question add(String question, String answer);

    Question remove(Question question);

    List<Question> getAll();

    Question getRandomQuestion();

    int size();
}

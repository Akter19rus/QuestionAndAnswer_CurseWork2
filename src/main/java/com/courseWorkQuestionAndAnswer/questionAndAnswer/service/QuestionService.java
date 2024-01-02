package com.courseWorkQuestionAndAnswer.questionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int size();

    Question find(String question);
}

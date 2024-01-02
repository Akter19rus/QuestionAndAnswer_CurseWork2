package com.courseWorkQuestionAndAnswer.questionAndAnswer.loading;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;

import java.util.Collection;

public interface QuestionLoadInterface {
    Question add(Question question);

    Question add(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();
}

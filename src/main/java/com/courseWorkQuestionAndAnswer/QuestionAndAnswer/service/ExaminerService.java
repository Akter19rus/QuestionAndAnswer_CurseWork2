package com.courseWorkQuestionAndAnswer.QuestionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.models.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}

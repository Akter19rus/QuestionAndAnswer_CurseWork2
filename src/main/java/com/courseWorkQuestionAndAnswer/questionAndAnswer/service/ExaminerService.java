package com.courseWorkQuestionAndAnswer.questionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}

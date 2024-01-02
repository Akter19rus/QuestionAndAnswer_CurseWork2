package com.courseWorkQuestionAndAnswer.questionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.exceptions.QuestionAlreadyAddedException;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> questionsRandomList = new HashSet<>();

        if (amount > questionService.size()) {
            throw new QuestionAlreadyAddedException("превышено количество вопросов!");
        }

        while (questionsRandomList.size() < amount) {
            questionsRandomList.add(questionService.getRandomQuestion());
        }
        return questionsRandomList;
    }
}

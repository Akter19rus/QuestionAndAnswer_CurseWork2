package com.courseWorkQuestionAndAnswer.questionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.exceptions.QuestionAlreadyAddedException;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.exceptions.QuestionNotFoundException;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.loading.QuestionLoad;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionLoad questionLoad;

    public JavaQuestionService(QuestionLoad questionLoad) {
        this.questionLoad = questionLoad;
    }

    public Question add(String question, String answer) {
        return questionLoad.add(question, answer);
    }

    @Override
    public Question remove(Question question) {
        return questionLoad.remove(question);
    }

    @Override
    public List<Question> getAll() {
        return questionLoad.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();

        int i = random.nextInt(questionLoad.getAll().size() + 1);
        return getAll().get(i);
    }

    public int size() {
        return questionLoad.getAll().size();
    }
}

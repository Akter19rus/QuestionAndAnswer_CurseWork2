package com.courseWorkQuestionAndAnswer.QuestionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.models.Question;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionService implements QuestionService{
    Set<Question> questions = new HashSet<>();
    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);

        if (this.questions.contains(question1.getQuestion())) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже существует!");
        } else {
            this.questions.add(question1.getQuestion(), question1);
            return "успешное добавление вопроса";
        }
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collections<Question> getAll() {
        return Collections.unmodifiableCollection(this.questions.values());
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}

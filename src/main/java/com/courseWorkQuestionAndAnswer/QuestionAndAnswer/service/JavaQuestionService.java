package com.courseWorkQuestionAndAnswer.QuestionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.exceptions.QuestionAlreadyAddedException;
import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.exceptions.QuestionNotFoundException;
import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.models.Question;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
@Repository
@Service
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionService javaQuestionService;
    public JavaQuestionService(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    List<Question> questions = new ArrayList<>(List.of(
            new Question("Какие особенности есть у Java",
                    "ООП концепты, Кроссплатформенность, Высокая производительность, Мультипоточность"),
            new Question("Что такое наследование?",
                    "Под наследованием подразумевается, что один класс может наследовать(\"extends\") другой класс."),
            new Question("Что такое инкапсуляция?",
                    "Инкапсуляция — это сокрытие реализации при помощи модификаторов доступа."),
            new Question("Что такое полиморфизм?",
                    "Полиморфизм — это способность программы идентично использовать объекты с одинаковым интерфейсом без информации о конкретном типе этого объекта."),
            new Question("Что такое Interface?",
                    "Множественное наследование не реализовано в джаве, поэтому чтобы преодолеть эту проблему, были добавлены интерфейсы в том виде, в котором мы их знаем."),
            new Question("Что такое mutable?",
                    "Mutable называются объекты, чьи состояния и переменные можно изменить после создания."),
            new Question("Что такое immutable?",
                    "Immutable называются объекты, состояния и переменные которых нельзя изменить после создания объекта."),
            new Question("Что имеется в виду под Collections в Java?",
                    "Collection — это фреймворк, который создан для сохранения и манипуляции объектами."),
            new Question("Что подразумевается под sorted в коллекциях?",
                    "Это значит, что группа элементов отсортирована в коллекции на основе данных элемента коллекции."),
            new Question("Что подразумевается под ordered в коллекциях?",
                    "Это означает, что элементы, которые хранятся в коллекции, основаны на значениях, добавленных в коллекцию. ")
    ));

    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyAddedException("Данный вопрос уже существует");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));

    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException("Данного вопроса не существует!");
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();

        int i = random.nextInt(getAll().size() + 1);
        return getAll().get(i);
    }

    public int size() {
        return getAll().size();
    }
}

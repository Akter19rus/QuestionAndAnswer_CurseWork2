package com.courseWorkQuestionAndAnswer.questionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.exceptions.QuestionAlreadyAddedException;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.exceptions.QuestionNotFoundException;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.loading.QuestionLoad;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.out;
import static org.apache.coyote.http11.Constants.QUESTION;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class QuestionServiceTest {
    QuestionService out = new JavaQuestionService(new QuestionLoad());

    public static Stream<Arguments> paramsForTest() {
        return Stream.of(Arguments.of("Вопрос", "Ответ"),
                Arguments.of("Вопрос1", "Ответ1"),
                Arguments.of("Вопрос2", "Ответ2"));
    }

    @ParameterizedTest
    @MethodSource("paramsForTest")
    public void addTest(String question, String answer) {
        out.add(question, answer);
        assertTrue(out.getAll().contains(new Question(question, answer)));
        Assertions.assertEquals(out.getAll().size(), 11);
    }

    @Test
    public void addThrowTest() {
        out.add("Вопрос3", "Ответ3");
        assertThrows(QuestionAlreadyAddedException.class,
                () -> {
                    out.add("Вопрос3", "Ответ3");
                });
    }

    @ParameterizedTest
    @MethodSource("paramsForTest")
    void removeTest(String question, String answer) {
        out.add(question, answer);
        assertTrue(out.remove(new Question(question, answer))
                .equals(new Question(question, answer)));
        assertThrows(QuestionNotFoundException.class, () ->
                out.find(question));

    }

    @ParameterizedTest
    @MethodSource("paramsForTest")
    public void getAllTest(String question, String answer) {
        out.add(question, answer);
        assertTrue(out.getAll().contains(new Question(question, answer)));
        Assertions.assertEquals(out.getAll().size(), 11);
    }

    @Test
    public void findTest() {
        out.add("Вопрос3", "Ответ3");
        Assertions.assertEquals(out.find("Вопрос3"),
                new Question("Вопрос3", "Ответ3"));
        assertThrows(QuestionNotFoundException.class, () ->
                out.find("Вопрос"));
    }
}

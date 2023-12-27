package com.courseWorkQuestionAndAnswer.QuestionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.exceptions.QuestionAlreadyAddedException;
import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.exceptions.QuestionNotFoundException;
import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.models.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class QuestionServiceTest {
    private final JavaQuestionService javaQuestionService = mock(JavaQuestionService.class);
    private QuestionService out;

    @BeforeEach
    public void out() {
        out = new JavaQuestionService(javaQuestionService);
    }

    private final String QUESTION = "Вопрос";
    private final String ANSWER = "Ответ";
    private final Question question = new Question(QUESTION, ANSWER);
    private final List questionsArr = new ArrayList<>(List.of(question));


    @Test
    public void addTest() {
        when(javaQuestionService.add(QUESTION, ANSWER))
                .thenReturn(question);
        Assertions.assertEquals(question, out.add(QUESTION, ANSWER));
        verify(javaQuestionService, times(1)).add(QUESTION, ANSWER);
    }

    @Test
    public void addThrowTest() {
        when(javaQuestionService.add(any(), any()))
                .thenThrow(QuestionAlreadyAddedException.class);
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(QUESTION, ANSWER));
    }

    @Test
    public void removeTest() {
        when(javaQuestionService.remove(question))
                .thenReturn(question);
        Assertions.assertEquals (question, out.add(QUESTION, ANSWER));
        verify(javaQuestionService, times(1))
                .remove(question);
    }

    @Test
    public void removeThrowTest() {
        when(javaQuestionService.remove(any()))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(question));
    }

    @Test
    public void getAllTest() {
        when(javaQuestionService.getAll())
                .thenReturn(questionsArr);
        Assertions.assertIterableEquals(questionsArr, out.getAll());
    }
}
package com.courseWorkQuestionAndAnswer.questionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.exceptions.QuestionAlreadyAddedException;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.exceptions.QuestionNotFoundException;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.loading.QuestionLoad;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class QuestionServiceTest {
    private final QuestionLoad questionLoad = mock(QuestionLoad.class);
    private QuestionService out;

    @BeforeEach
    public void out() {
        out = new JavaQuestionService(questionLoad);
    }

    public final String QUESTION = "Вопрос";
    public final String ANSWER = "Ответ";
    private final Question question = new Question(QUESTION, ANSWER);
    private final List questionsArr = new ArrayList<>(List.of(question));



    @Test
    public void addTest() {
        when(questionLoad.add(QUESTION, ANSWER))
                .thenReturn(question);
        Assertions.assertEquals(question, out.add(QUESTION, ANSWER));
        verify(questionLoad, times(1)).add(QUESTION, ANSWER);
//        out.add(question.getQuestion(), question.getAnswer());
//        Assertions.assertTrue(out.getAll().contains(question));
//        Assertions.assertEquals(out.getAll().size(), 11);
    }

    @Test
    public void addThrowTest() {
        when(questionLoad.add(any(), any()))
                .thenThrow(QuestionAlreadyAddedException.class);
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(QUESTION, ANSWER));
    }

    @Test
    public void removeTest() {
        when(questionLoad.remove(question))
                .thenReturn(question);
        Assertions.assertEquals(question, out.remove(question));
        verify(questionLoad, times(1)).remove(question);
    }

    @Test
    public void removeThrowTest() {
        when(questionLoad.remove(any()))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(question));
    }

    @Test
    public void getAllTest() {
        when(questionLoad.getAll())
                .thenReturn(questionsArr);
        Assertions.assertIterableEquals(questionsArr, out.getAll());
    }
}
package com.courseWorkQuestionAndAnswer.questionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.questionAndAnswer.exceptions.QuestionAlreadyAddedException;
import com.courseWorkQuestionAndAnswer.questionAndAnswer.models.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExamServiceTest {
    private final JavaQuestionService javaQuestionService = mock(JavaQuestionService.class);
    private ExaminerService out;

    @BeforeEach
    public void out() {
        out = new ExaminerServiceImpl(javaQuestionService);
    }

    private final Question QUESTION1 = new Question("Вопрос 1", "Ответ 1");
    private final Question QUESTION2 = new Question("Вопрос 2", "Ответ 2");

    @Test
    public void testThrow() {
        when(javaQuestionService.size()).thenReturn(5);
        assertThrows(QuestionAlreadyAddedException.class, () -> out.getQuestions(7));
    }

    @Test
    public void getQuestionTest() {
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(QUESTION1, QUESTION2);
        when(javaQuestionService.size())
                .thenReturn(2);
        assertEquals(out.getQuestions(2).size(), 2);
    }

    @Test
    public void containsTest() {
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(QUESTION1, QUESTION2);
        when(javaQuestionService.size())
                .thenReturn(5);
        assertTrue(out.getQuestions(2).contains(QUESTION2));
    }
}

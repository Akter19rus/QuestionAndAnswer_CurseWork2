package com.courseWorkQuestionAndAnswer.QuestionAndAnswer.service;

import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.exceptions.StorageIsFullException;
import com.courseWorkQuestionAndAnswer.QuestionAndAnswer.models.Question;
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
    private final Question QUESTION3 = new Question("Вопрос 3", "Ответ 3");

    @Test
    public void testThrow() {
        when(javaQuestionService.size()).thenReturn(5);
        assertThrows(StorageIsFullException.class, () -> out.getQuestions(7));
    }

    @Test
    public void getQuestionTest() {
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(QUESTION1, QUESTION2);
        when(javaQuestionService.size())
                .thenReturn(10);
        assertEquals(out.getQuestions(4).size(), 4);
    }

    @Test
    public void containsTest() {
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(QUESTION2, QUESTION3);
        when(javaQuestionService.size())
                .thenReturn(10);
        assertTrue(out.getQuestions(4).contains(QUESTION1));
    }
}

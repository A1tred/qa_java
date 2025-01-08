package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

// Используем MockitoJUnitRunner для автоматической инициализации моков
@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;
    // Создаём мок объекта Feline
    @Mock
    private Feline felineMock;

    // Инициализируем объект Lion перед каждым тестом
    @Before
    public void setUp() throws Exception {
        // Инициализируем Lion с полом "Самец",так как в этих тестах нас не интересуют различные варианты пола
        lion = new Lion("Самец", felineMock);
    }

    // Тестируем метод getKittens()
    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(1);
        int kittens = lion.getKittens();
        assertEquals("Метод getKittens() должен возвращать значение от feline", 1, kittens);
        verify(felineMock, times(1)).getKittens();
    }

    // Тестируем метод getFood()
    @Test
    public void testGetFood() throws Exception {
        List<String> foodList = Arrays.asList("Мясо", "Рыба", "Птица");
        when(felineMock.getFood("Хищник")).thenReturn(foodList);
        List<String> food = lion.getFood();
        assertEquals("Метод getFood() должен возвращать список еды от feline", foodList, food);
        verify(felineMock, times(1)).getFood("Хищник");
    }
}

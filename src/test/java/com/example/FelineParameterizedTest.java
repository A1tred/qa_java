package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int inputKittensCount;
    private final int expectedKittens;

    private Feline feline;

    // Конструктор для приёма параметров теста
    public FelineParameterizedTest(int inputKittensCount, int expectedKittens) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittens = expectedKittens;
    }

    // Предоставляем данные для параметризованных тестов
    @Parameterized.Parameters(name = "Тестирование getKittens({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {5, 5},
                {-1, -1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE}
        });
    }

    @Before
    public void setUp() {
        feline = new Feline();
    }

    // Тестируем метод getKittens(int kittensCount)
    @Test
    public void testGetKittensWithParameters() {
        int actualKittens = feline.getKittens(inputKittensCount);
        assertEquals("Метод getKittens(" + inputKittensCount + ") должен возвращать " + expectedKittens,
                expectedKittens, actualKittens);
    }
}

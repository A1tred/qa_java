package com.example;

import org.junit.Test;
import org.junit.Before;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    // Тестируем метод eatMeat()
    @Test
    public void testEatMeatReturnsPredatorFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Метод eatMeat() должен возвращать список еды для хищника", expectedFood, actualFood);
    }

    // Тестируем метод getFamily()
    @Test
    public void testGetFamilyReturnsFelineFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Метод getFamily() должен возвращать 'Кошачьи'", expectedFamily, actualFamily);
    }

    // Тестируем метод getKittens() без параметров
    @Test
    public void testGetKittensReturnsOneByDefault() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals("Метод getKittens() без параметров должен возвращать 1", expectedKittens, actualKittens);
    }
}

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

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    // Создаем мок-объект Feline
    @Mock
    private Feline felineMock;

    @Before
    public void setUp() {
        // Создаем экземпляр класса Cat, передавая замокированный Feline
        cat = new Cat(felineMock);
    }

    // Тестируем метод getSound()
    @Test
    public void getSoundShouldReturnMeow() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals("Метод getSound() должен возвращать 'Мяу'", expectedSound, actualSound);
    }

    // Тестируем метод getFood()
    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals("Метод getFood() должен возвращать список еды хищника", expectedFood, actualFood);
        verify(felineMock, times(1)).eatMeat();
    }
}

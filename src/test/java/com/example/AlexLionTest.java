package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    private AlexLion alexLion;

    // Создаём мок объекта Feline
    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        // Создаём экземпляр AlexLion с замоканным Feline
        alexLion = new AlexLion(feline);
    }

    // Тестируем, что метод getKittens() возвращает 0
    @Test
    public void testGetKittensReturnsZero() {
        int kittens = alexLion.getKittens();
        assertEquals("У Алекса нет львят, метод должен вернуть 0", 0, kittens);
    }

    // Тестируем, что метод getFriends() возвращает правильный список друзей
    @Test
    public void testGetFriendsReturnsCorrectList() {
        List<String> friends = alexLion.getFriends();
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals("Список друзей должен содержать Марти, Глорию и Мелмана", expectedFriends, friends);
    }

    // Тестируем, что метод getPlaceOfLiving() возвращает правильное место проживания
    @Test
    public void testGetPlaceOfLivingReturnsCorrectPlace() {
        String placeOfLiving = alexLion.getPlaceOfLiving();
        assertEquals("Место проживания должно быть 'Нью-Йоркский зоопарк'", "Нью-Йоркский зоопарк", placeOfLiving);
    }

    // Тестируем, что метод doesHaveMane() возвращает true, так как Алекс — самец
    @Test
    public void testDoesHaveManeReturnsTrue() {
        boolean hasMane = alexLion.doesHaveMane();
        assertTrue("Алекс — самец, поэтому должен иметь гриву", hasMane);
    }


    // Тестируем, что метод getFood() возвращает корректный список еды
    @Test
    public void testGetFoodReturnsFelineFood() throws Exception {
        // Настраиваем мок для метода getFood() класса Feline
        List<String> foodList = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(foodList);
        List<String> food = alexLion.getFood();
        assertEquals("Метод getFood() должен возвращать список еды от Feline", foodList, food);
        verify(feline, times(1)).getFood("Хищник");
    }
}

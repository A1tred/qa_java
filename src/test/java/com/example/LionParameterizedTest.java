package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Указываем, что этот тестовый класс будет использовать параметризацию
@RunWith(Parameterized.class)
public class LionParameterizedTest {

    // Параметры для каждого тестового случая
    private final String sex;                // Пол льва ("Самец", "Самка", и т.д.)
    private final boolean expectedHasMane;   // Ожидается ли грива (true или false)
    private final boolean expectException;   // Ожидается ли исключение при создании льва

    private Feline felineMock;

    // Конструктор, который будет вызван для каждого набора параметров
    public LionParameterizedTest(String sex, boolean expectedHasMane, boolean expectException) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectException = expectException;
    }

    // Предоставляем данные для параметризованных тестов
    @Parameterized.Parameters(name = "Пол: {0}, ожидается грива: {1}, ожидается исключение: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, false},       // Случай для самца: грива есть, исключения нет
                {"Самка", false, false},      // Случай для самки: гривы нет, исключения нет
                {"Неизвестно", false, true},  // Некорректный пол: ожидается исключение
                {"", false, true},            // Пустая строка: ожидается исключение
                {null, false, true}           // null значение: ожидается исключение
        });
    }

    @Before
    public void setUp() {
        // Создаем мок объекта Feline
        felineMock = mock(Feline.class);
    }

    // Тестируем конструктор Lion и метод doesHaveMane()
    @Test
    public void testLionConstructorAndDoesHaveMane() {
        try {
            Lion lion = new Lion(sex, felineMock);
            if (expectException) {
                fail("Ожидалось исключение для пола: " + sex);
            }
            assertEquals("Неверное значение наличия гривы для пола: " + sex,
                    expectedHasMane, lion.doesHaveMane());
        } catch (Exception e) {
            if (!expectException) {
                fail("Не ожидалось исключение для пола: " + sex);
            }
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }
}

package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void productInitialization() {
        // Позитивный тест для проверки корректной инициализации объекта Product
        String expectedName = "Хлеб";
        int expectedPrice = 50;
        Product product = new Product(expectedName, expectedPrice);

        assertAll("Проверка корректности полей Product после инициализации",
                () -> assertEquals(expectedName, product.name, "Имя продукта должно соответствовать заданному"),
                () -> assertEquals(expectedPrice, product.price, "Цена продукта должна соответствовать заданной")
        );
    }

    @Test
    void productInitializationWithNullName() {
        // Тест на исключение при попытке создания Product с null в качестве имени
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product(null, 50);
        }, "Должно быть выброшено IllegalArgumentException при создании продукта с null в качестве имени");
        assertEquals("Имя не может быть нулевым или пустым", exception.getMessage());
    }

    @Test
    void productInitializationWithEmptyName() {
        // Тест на исключение при попытке создания Product с пустым именем
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product("", 50);
        }, "Должно быть выброшено IllegalArgumentException при создании продукта с пустым именем");
        assertEquals("Имя не может быть нулевым или пустым", exception.getMessage());
    }

    @Test
    void productInitializationWithNegativePrice() {
        // Тест на исключение при попытке создания Product с отрицательной ценой
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product("Хлеб", -1);
        }, "Должно быть выброшено IllegalArgumentException при создании продукта с отрицательной ценой");
        assertEquals("Цена не может быть отрицательной", exception.getMessage());
    }
}

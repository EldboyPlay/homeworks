package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;
    Product product;

    @BeforeEach
    void setUp() {
        // Этот метод будет выполняться перед каждым тестом, инициализируя объекты.
        customer = new Customer("Иван", 500);
        product = new Product("Хлеб", 50);
    }

    @Test
    void buyProductSuccess() {
        assertTrue(customer.buyProduct(product), "Покупатель должен успешно купить продукт");
    }

    @Test
    void buyProductFail() {
        Customer poorCustomer = new Customer("Иван", 30);
        assertFalse(poorCustomer.buyProduct(product), "Покупатель не должен иметь возможности купить продукт, если у него недостаточно средств");
    }

    @Test
    void customerBalanceUpdatedAfterPurchase() {
        customer.buyProduct(product);
        assertEquals(450, customer.money, "Баланс покупателя должен быть уменьшен на стоимость продукта после покупки");
    }

    @Test
    void productAddedToPurchasedListAfterPurchase() {
        customer.buyProduct(product);
        assertTrue(customer.productsBought.contains(product.name), "Имя продукта должно быть добавлено в список купленных товаров после покупки");
    }

    @Disabled("Демонстрация игнорирования теста")
    @Test
    void ignoredTest() {
        fail("Этот тест не должен выполняться, так как он отключен.");
    }
}

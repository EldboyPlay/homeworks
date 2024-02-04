import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BonusServiceTest {
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // Тестовые данные
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // Выполнение целевого действия
        long actual = service.calculate(amount, registered);

        // Проверка результата
        assertEquals(expected, actual);
    }

    // Добавьте другие тестовые случаи здесь
}

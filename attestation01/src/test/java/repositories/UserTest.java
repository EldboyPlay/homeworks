package repositories;

import model.User;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void createUserSuccessfully() {
        assertDoesNotThrow(() -> {
            new User("1", LocalDateTime.now(), "user1", "password1", "password1", "Ivanov", "Ivan", null, 30, true);
        });
    }

    @Test
    void gettersTest() {
        User user = new User("1", LocalDateTime.now(), "user1", "password1", "password1", "Ivanov", "Ivan", null, 30, true);
        assertEquals("1", user.getId());
        assertEquals("user1", user.getLogin());
        assertEquals("Ivanov", user.getLastName());
        assertEquals("Ivan", user.getFirstName());
        assertNull(user.getMiddleName());
        assertEquals(30, user.getAge());
        assertTrue(user.isWorker());
    }

    @Test
    void invalidIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("invalid_id", LocalDateTime.now(), "user1", "password1", "password1", "Ivanov", "Ivan", null, 30, true);
        });
    }

    @Test
    void invalidLoginThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("1", LocalDateTime.now(), "12345", "password1", "password1", "Ivanov", "Ivan", null, 30, true);
        });
    }
}



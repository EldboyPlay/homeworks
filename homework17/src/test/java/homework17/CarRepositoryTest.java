package homework17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CarRepositoryTest {
    private CarRepository repository;
    private final String testFileName = "test_cars.txt";

    @BeforeEach
    public void setUp() throws Exception {
        // Подготовка тестовых данных
        List<String> lines = List.of(
                "1,Toyota,Corolla,2020,150,10,5,7",
                "2,Ferrari,488,2021,670,8,4,9",
                "3,Lamborghini,Huracan,2019,610,9,6,8"
        );
        Files.write(Paths.get(testFileName), lines);
        repository = new CarRepositoryFileImpl(testFileName);
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Очистка тестовых данных
        Files.deleteIfExists(Paths.get(testFileName));
    }

    @Test
    public void testFindAll() {
        List<Car> cars = repository.findAll();
        assertEquals(3, cars.size(), "findAll should return 3 cars");
    }

    @Test
    public void testFindById() {
        Car car = repository.findById(1);
        assertNotNull(car, "Car with ID 1 should be found");
        assertEquals("Toyota", car.getBrand(), "The brand of the car should be Toyota");
    }

    @Test
    public void testSave() {
        Car newCar = new Car(4, "Nissan", "GTR", 2022, 565, 7, 7, 8);
        repository.save(newCar);
        assertEquals(4, repository.findAll().size(), "After save, findAll should return 4 cars");
    }

    @Test
    public void testDelete() {
        Car car = repository.findById(1);
        assertNotNull(car, "Car with ID 1 should be found before deletion");
        repository.delete(car);
        assertNull(repository.findById(1), "Car with ID 1 should be null after deletion");
        assertEquals(2, repository.findAll().size(), "After delete, findAll should return 2 cars");
    }
}

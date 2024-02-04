package repository;

import model.Car;
import java.util.List;

public interface CarsRepository {
    List<Car> readCarsFromFile(String fileName);
    void writeCarsToFile(String fileName, List<Car> cars);
    // Можно добавить другие методы работы с автомобилями, если это необходимо
}

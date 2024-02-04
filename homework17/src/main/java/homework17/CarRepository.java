package homework17;

import java.util.List;

public interface CarRepository {
    List<Car> findAll();
    Car findById(int id);
    void save(Car car);
    void delete(Car car);
}

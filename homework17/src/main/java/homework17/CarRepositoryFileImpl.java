package homework17;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class CarRepositoryFileImpl implements CarRepository {
    private final String fileName;

    public CarRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] attributes = line.split(",");
                Car car = new Car(Integer.parseInt(attributes[0]), attributes[1], attributes[2], Integer.parseInt(attributes[3]),
                        Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]),
                        Integer.parseInt(attributes[6]), Integer.parseInt(attributes[7]));
                cars.add(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car findById(int id) {
        return findAll().stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Car car) {
        List<Car> cars = findAll();
        cars.add(car);
        writeCarsToFile(cars);
    }

    @Override
    public void delete(Car car) {
        List<Car> cars = findAll();
        cars.removeIf(c -> c.getId() == car.getId());
        writeCarsToFile(cars);
    }

    private void writeCarsToFile(List<Car> cars) {
        List<String> lines = new ArrayList<>();
        for (Car car : cars) {
            lines.add(car.toFileString());
        }
        try {
            Path file = Paths.get(fileName);
            Files.write(file, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

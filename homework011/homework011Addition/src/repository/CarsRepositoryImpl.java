package repository;

import model.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {

    private final Path rootPath = Paths.get("src", "data");

    @Override
    public List<Car> readCarsFromFile(String fileName) {
        Path file = rootPath.resolve(fileName);
        try {
            return Files.lines(file)
                    .map(this::parseCar)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(); // Возвращаем пустой список, если чтение файла не удалось
        }
    }

    private Car parseCar(String line) {
        String[] parts = line.split("\\|");
        return new Car(parts[0], parts[1], parts[2], Long.parseLong(parts[3]), Long.parseLong(parts[4]));
    }

    @Override
    public void writeCarsToFile(String fileName, List<Car> cars) {
        Path file = rootPath.resolve(fileName);
        List<String> lines = cars.stream()
                .map(this::formatCarString)
                .collect(Collectors.toList());
        try {
            Files.write(file, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatCarString(Car car) {
        return String.join("|",
                car.getNumber(),
                car.getModel(),
                car.getColor(),
                String.valueOf(car.getMileage()),
                String.valueOf(car.getCost()));
    }
}

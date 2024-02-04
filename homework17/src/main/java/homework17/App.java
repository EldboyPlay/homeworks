package homework17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        CarRepository carRepository = new CarRepositoryFileImpl("cars.txt");

        // Чтение всех автомобилей
        List<Car> cars = carRepository.findAll();
        if (cars.isEmpty()) {
            System.out.println("Список автомобилей пуст.");
        } else {
            for (Car car : cars) {
                System.out.println(car);
            }
        }

        // Добавление нового автомобиля
        Car newCar = new Car(10, "Toyota", "Corolla", 2020, 132, 8, 10, 7);
        carRepository.save(newCar);

        // Удаление автомобиля
        Car carToDelete = carRepository.findById(10);
        if (carToDelete != null) {
            carRepository.delete(carToDelete);
        }

        // Снова читаем все автомобили после изменений
        cars = carRepository.findAll();

        // Запись информации в файл
        try {
            List<String> carInfo = cars.stream()
                    .map(Car::toFileString)
                    .collect(Collectors.toList());
            Files.write(Paths.get("results.txt"), carInfo);
            System.out.println("Результаты были успешно записаны в файл results.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Произошла ошибка при записи в файл results.txt");
        }
    }
}

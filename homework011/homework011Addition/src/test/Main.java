package test;

import model.Car;
import repository.CarsRepository;
import repository.CarsRepositoryImpl;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CarsRepository carsRepository = new CarsRepositoryImpl();

        // Чтение списка автомобилей из файла
        List<Car> cars = carsRepository.readCarsFromFile("cars.txt");

        // Вывод информации о всех автомобилях
        System.out.println("Автомобили в базе:");
        System.out.println("Number\tModel\tColor\tMileage\tCost");
        cars.forEach(car -> System.out.println(car.getNumber() + "\t" +
                car.getModel() + "\t" +
                car.getColor() + "\t" +
                car.getMileage() + "\t" +
                car.getCost()));

        // Номера всех автомобилей заданного цвета или пробега
        String colorToFind = "Black";
        long mileageToFind = 0;
        String filteredNumbers = cars.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.joining(" "));
        System.out.println("Номера автомобилей по цвету или пробегу: " + filteredNumbers);

        // Количество уникальных моделей в ценовом диапазоне
        long minPrice = 700000L;
        long maxPrice = 800000L;
        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getCost() >= minPrice && car.getCost() <= maxPrice)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("Уникальные автомобили: " + uniqueModelsCount + " шт.");

        // Цвет автомобиля с минимальной стоимостью
        String minCostColor = cars.stream()
                .min(Comparator.comparingLong(Car::getCost))
                .map(Car::getColor)
                .orElse("Не найден");
        System.out.println("Цвет автомобиля с минимальной стоимостью: " + minCostColor);

        // Средняя стоимость искомой модели (Toyota)
        String modelToFind = "Toyota";
        double averageCost = cars.stream()
                .filter(car -> car.getModel().equals(modelToFind))
                .mapToLong(Car::getCost)
                .average()
                .orElse(0.0);
        System.out.printf("Средняя стоимость модели %s: %.2f\n", modelToFind, averageCost);
    }
}

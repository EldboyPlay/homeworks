import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Создание списка автомобилей
        List<Automobile> automobiles = List.of(
                new Automobile("a123me", "Mercedes", "White", 0, 8300000),
                new Automobile("b873of", "Volga", "Black", 0, 673000),
                new Automobile("w487mn", "Lexus", "Grey", 76000, 900000),
                new Automobile("p987hj", "Volga", "Red", 610, 704340),
                new Automobile("c987ss", "Toyota", "White", 254000, 761000),
                new Automobile("o983op", "Toyota", "Black", 698000, 740000),
                new Automobile("p146op", "BMW", "White", 271000, 850000),
                new Automobile("u893ii", "Toyota", "Purple", 210900, 440000),
                new Automobile("l097df", "Toyota", "Black", 108000, 780000),
                new Automobile("y876wd", "Toyota", "Black", 160000, 1000000)
        );

        // Вывод информации о всех автомобилях
        System.out.println("Автомобили в базе:");
        System.out.println("Number\tModel\tColor\tMileage\tCost");
        automobiles.forEach(auto -> System.out.println(auto.getNumber() + "\t" +
                auto.getModel() + "\t" +
                auto.getColor() + "\t" +
                auto.getMileage() + "\t" +
                auto.getCost()));

        // Номера всех автомобилей заданного цвета или пробега
        String colorToFind = "Black";
        long mileageToFind = 0;
        String filteredNumbers = automobiles.stream()
                .filter(auto -> auto.getColor().equals(colorToFind) || auto.getMileage() == mileageToFind)
                .map(Automobile::getNumber)
                .collect(Collectors.joining(" "));
        System.out.println("Номера автомобилей по цвету или пробегу: " + filteredNumbers);

        // Количество уникальных моделей в ценовом диапазоне
        long minPrice = 700000L;
        long maxPrice = 800000L;
        long uniqueModelsCount = automobiles.stream()
                .filter(auto -> auto.getCost() >= minPrice && auto.getCost() <= maxPrice)
                .map(Automobile::getModel)
                .distinct()
                .count();
        System.out.println("Уникальные автомобили: " + uniqueModelsCount + " шт.");

        // Цвет автомобиля с минимальной стоимостью
        String minCostColor = automobiles.stream()
                .min(Comparator.comparingLong(Automobile::getCost))
                .map(Automobile::getColor)
                .orElse("Не найден");
        System.out.println("Цвет автомобиля с минимальной стоимостью: " + minCostColor);

        // Средняя стоимость искомой модели (Toyota)
        String modelToFind = "Toyota";
        double averageCost = automobiles.stream()
                .filter(auto -> auto.getModel().equals(modelToFind))
                .mapToLong(Automobile::getCost)
                .average()
                .orElse(0.0);
        System.out.printf("Средняя стоимость модели %s: %.2f\n", modelToFind, averageCost);
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        // Попытка чтения параметров из файла
        try {
            List<String> fileContent = readParametersFromFile("parameters.txt");
            for (String line : fileContent) {
                String[] carData = line.split(",");
                Car car = new Car(carData[0], carData[1], Integer.parseInt(carData[2]), Integer.parseInt(carData[3]),
                        Integer.parseInt(carData[4]), Integer.parseInt(carData[5]), Integer.parseInt(carData[6]));
                cars.add(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Дополнительные действия с объектами Car
        for (Car car : cars) {
            System.out.println(car);
        }

        // Предположим, что мы хотим записать информацию об автомобилях в файл
        try {
            List<String> carInfo = new ArrayList<>();
            for (Car car : cars) {
                carInfo.add(car.toString());
            }
            writeResultsToFile("results.txt", carInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readParametersFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    public static void writeResultsToFile(String filePath, List<String> lines) throws IOException {
        Files.write(Paths.get(filePath), lines);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    // Конструктор без параметров
    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    // Метод для добавления автомобиля в гараж
    public void addCar(Car car) {
        parkedCars.add(car);
    }

    // Метод для удаления автомобиля из гаража
    public boolean removeCar(Car car) {
        return parkedCars.remove(car);
    }

    // Геттер для получения списка автомобилей
    public List<Car> getParkedCars() {
        return parkedCars;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + parkedCars +
                '}';
    }
}

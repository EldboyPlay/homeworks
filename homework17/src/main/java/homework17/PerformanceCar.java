package homework17;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerformanceCar extends Car {
    private String[] addOns;

    public PerformanceCar() {
        // Необходимо вызвать конструктор суперкласса с параметрами, подставив значения по умолчанию или 0 для int
        super(0, "", "", 0, 0, 0, 0, 0);
        this.addOns = new String[0];
    }

    public PerformanceCar(int id, String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability, String[] addOns) {
        super(id, brand, model, year, (int)(horsepower * 1.5), acceleration, (int)(suspension * 0.75), durability);
        this.addOns = addOns;
    }

    // Переопределите метод toString(), если необходимо включить addOns в строковое представление
    @Override
    public String toString() {
        return "PerformanceCar{" +
                "id=" + getId() +
                ", brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", horsepower=" + getHorsepower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", addOns=" + String.join(", ", addOns) + // Следует использовать Arrays.toString(addOns), если addOns не будет преобразовано в List<String>
                '}';
    }
}

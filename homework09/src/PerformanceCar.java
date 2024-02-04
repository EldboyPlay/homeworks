import java.util.Arrays;

public class PerformanceCar extends Car {
    private String[] addOns;

    public PerformanceCar() {
        super();
        this.addOns = new String[0];
    }

    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability, String[] addOns) {
        super(brand, model, year, (int)(horsepower * 1.5), acceleration, (int)(suspension * 0.75), durability);
        this.addOns = addOns;
    }

    // Геттер и сеттер для addOns
    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "PerformanceCar{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", horsepower=" + getHorsepower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", addOns=" + Arrays.toString(addOns) +
                '}';
    }

    // Переопределение методов equals() и hashCode() с учетом addOns
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerformanceCar)) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Arrays.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{super.hashCode(), addOns});
    }
}

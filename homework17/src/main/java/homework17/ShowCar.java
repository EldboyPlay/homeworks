package homework17;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowCar extends Car {
    private int stars;

    public ShowCar() {
        super();
        this.stars = 0;
    }

    public ShowCar(int id, String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability, int stars) {
        super(id, brand, model, year, horsepower, acceleration, suspension, durability);
        this.stars = stars;
    }
}

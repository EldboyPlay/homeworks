package homework17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public String toFileString() {
        return id + "," + brand + "," + model + "," + year + "," +
                horsepower + "," + acceleration + "," + suspension + "," +
                durability;
    }
}

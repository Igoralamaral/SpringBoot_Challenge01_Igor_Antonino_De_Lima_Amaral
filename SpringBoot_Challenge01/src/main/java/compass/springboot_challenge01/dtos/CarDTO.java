package compass.springboot_challenge01.dtos;

import compass.springboot_challenge01.models.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

    private Long chassiId;
    private String model;
    private String brand;
    private String color;
    private String fabricationYear;

    public CarDTO(String model, String brand, String color, String fabricationYear) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }

    public CarDTO(Car car) {
        this.chassiId = car.getChassiId();
        this.model = car.getModel();
        this.brand = car.getBrand();
        this.color = car.getColor();
        this.fabricationYear = car.getFabricationYear();;
    }
}

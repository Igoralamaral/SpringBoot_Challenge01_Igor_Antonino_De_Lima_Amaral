package compass.springboot_challenge01.models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chassiId;

    @NotBlank
    private String model;

    @NotBlank
    private String brand;

    @NotBlank
    private String color;

    @NotBlank
    private String fabricationYear;

    public Car(String model, String brand, String color, String fabricationYear) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }

    public Car() {

    }

    public Long getChassiId() {
        return chassiId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }
}

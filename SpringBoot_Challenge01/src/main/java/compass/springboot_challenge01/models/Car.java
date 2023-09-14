package compass.springboot_challenge01.models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chassi_id")
    private Long chassiId;

    @NotEmpty(message = "Insert a valid model")
    private String model;

    @NotEmpty(message = "Choose one of this brands: Ford, Chevrolet, BMW or Volvo")
    private String brand;

    @NotEmpty(message = "Insert a valid color")
    private String color;

    @NotEmpty(message = "Insert a valid fabrication year in format: year/year")
    @Column(name = "fabrication_year")
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

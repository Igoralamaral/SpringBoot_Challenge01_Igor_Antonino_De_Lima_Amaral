package compass.springboot_challenge01.dtos;

import compass.springboot_challenge01.models.Car;

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

    public Long getChassiId() {
        return chassiId;
    }

    public void setChassiId(Long chassiId) {
        this.chassiId = chassiId;
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

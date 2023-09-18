package compass.springboot_challenge01.enums;

public enum BrandsEnum {

    FORD("Ford"), CHEVROLET("Chevrolet"), BMW("BMW"), VOLVO("Volvo");

    private String brand;

    BrandsEnum(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

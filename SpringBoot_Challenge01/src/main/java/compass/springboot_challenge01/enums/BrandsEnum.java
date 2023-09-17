package compass.springboot_challenge01.enums;

import java.util.Arrays;
import java.util.List;

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

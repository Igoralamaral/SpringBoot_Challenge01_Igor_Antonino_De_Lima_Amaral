package compass.springboot_challenge01.services;

import compass.springboot_challenge01.dtos.CarDTO;
import compass.springboot_challenge01.enums.BrandsEnum;
import compass.springboot_challenge01.exceptions.*;
import compass.springboot_challenge01.models.Car;
import compass.springboot_challenge01.repositories.CarRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Stream;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarDTO createCar(@RequestBody @Valid Car car){
        //validating date in format "year/year"
        boolean isValidData = car.getFabricationYear().matches("^([0-9]{4})+[/]+([0-9]{4})");
        if(!isValidData){
            throw new InvalidFabricationYear("Please insert a valid date in format yyyy/yyyy");
        }
        String data = car.getFabricationYear();
        String[] dataSplit = data.split("/");
        Integer year1 = Integer.parseInt(dataSplit[0]);
        Integer year2 = Integer.parseInt(dataSplit[1]);
        if((year1 < 1970 || year2 < 1970) || (year1 > 2024 || year2 > 2024)){
            throw new InvalidFabricationYear("Date under 1970 or above 2024 are not allowed");
        }

        //validating if a brand is accepted
        List<BrandsEnum> brands = Arrays.asList(BrandsEnum.values());
        boolean isValidBrand = brands.stream().anyMatch(n -> car.getBrand().equalsIgnoreCase(n.toString()));;
        if (isValidBrand) {
            carRepository.save(car);
            CarDTO carDTO = new CarDTO(car);
            return carDTO;
        } else {
            throw new BrandNotAccepted("Please select a valid brand");
        }
    }

    public CarDTO findById(Long id) {
        Car car = carRepository.findById(id).get();
        CarDTO carDTO = new CarDTO(car);
        return carDTO;
    }
}

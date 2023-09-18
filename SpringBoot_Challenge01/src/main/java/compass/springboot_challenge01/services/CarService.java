package compass.springboot_challenge01.services;

import compass.springboot_challenge01.dtos.CarDTO;
import compass.springboot_challenge01.enums.BrandsEnum;
import compass.springboot_challenge01.exceptions.*;
import compass.springboot_challenge01.models.Car;
import compass.springboot_challenge01.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.*;

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
        boolean isValidBrand = brands.stream().anyMatch(n -> car.getBrand().equalsIgnoreCase(n.toString()));
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

    public CarDTO updateCar(Long id, @RequestBody @Valid Car car) {
        Car carFind = carRepository.findById(id).get();
        carFind.setModel(car.getModel());
        carFind.setBrand(car.getBrand());
        carFind.setColor(car.getColor());
        carFind.setFabricationYear(car.getFabricationYear());
        this.createCar(carFind);
        CarDTO carDTO = new CarDTO(carFind);
        return carDTO;
    }

    public CarDTO updatePartialCar(Long id, @RequestBody @Valid Map<String, Object> fields) {
        Car carFind = carRepository.findById(id).get();
        fields.forEach((propertyName, propertyValue) -> {
             Field field = ReflectionUtils.findField(Car.class, propertyName);
             field.setAccessible(true);
             ReflectionUtils.setField(field, carFind, propertyValue);
        });
        this.createCar(carFind);
        CarDTO carDTO = new CarDTO(carFind);
        return carDTO;
    }

    public void deleteCar(Long id){
        Car car = carRepository.findById(id).get();
        carRepository.deleteById(car.getChassiId());
    }
}

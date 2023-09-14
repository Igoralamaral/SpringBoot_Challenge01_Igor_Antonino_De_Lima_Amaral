package compass.springboot_challenge01.services;

import compass.springboot_challenge01.dtos.CarDTO;
import compass.springboot_challenge01.models.Car;
import compass.springboot_challenge01.repositories.CarRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarDTO createCar(@RequestBody Car car){
        List<String> brands = List.of("Ford", "Chevrolet", "BMW", "Volvo");
        boolean isValidBrand = brands.stream().anyMatch(n -> car.getBrand().contentEquals(n));
        if(isValidBrand){
            carRepository.save(car);
            CarDTO carDTO = new CarDTO(car);
            return carDTO;
        }else{
            throw new RuntimeException();
        }
    }
    public CarDTO findById(Long id){
        Car car = carRepository.findById(id).get();
        CarDTO carDTO = new CarDTO(car);
        return carDTO;
    }
}

package compass.springboot_challenge01.services;

import compass.springboot_challenge01.dtos.CarDTO;
import compass.springboot_challenge01.models.Car;
import compass.springboot_challenge01.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public ResponseEntity<Car> createCar(@RequestBody Car car){
        List<String> brands = List.of("Ford", "Chevrolet", "BMW", "Volvo");
        boolean isValidBrand = brands.stream().anyMatch(n -> car.getBrand().contentEquals(n));
        if(isValidBrand) {
            Car carSave = carRepository.save(car);
            return ResponseEntity.status(HttpStatus.CREATED).body(car);
        }

        return null;
    }

    public ResponseEntity<CarDTO> findById(Long id){
        Car car = carRepository.findById(id).get();
        CarDTO carDTO = new CarDTO(car);
        return ResponseEntity.ok().body(carDTO);
    }
}

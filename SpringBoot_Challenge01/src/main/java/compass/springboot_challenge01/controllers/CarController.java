package compass.springboot_challenge01.controllers;

import compass.springboot_challenge01.dtos.CarDTO;
import compass.springboot_challenge01.models.Car;
import compass.springboot_challenge01.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<CarDTO> createCar(@RequestBody @Valid Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(car));
    }

    @GetMapping("/{chassiId}")
    public ResponseEntity<CarDTO> findById(@PathVariable Long chassiId) {
        return ResponseEntity.ok(carService.findById(chassiId));
    }

    @PutMapping("/{chassiId}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long chassiId, @RequestBody @Valid Car car) {
        return ResponseEntity.ok(carService.updateCar(chassiId, car));
    }

    @PatchMapping("/{chassiId}")
    public ResponseEntity<CarDTO> updatePartialCar(@PathVariable Long chassiId, @RequestBody @Valid Map<String, Object> fields) {
        return ResponseEntity.ok(carService.updatePartialCar(chassiId, fields));
    }

    @DeleteMapping("/{chassiId}")
    public void deleteCar(@PathVariable Long chassiId) {
        carService.deleteCar(chassiId);
    }
}

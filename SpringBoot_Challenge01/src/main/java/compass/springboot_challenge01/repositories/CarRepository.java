package compass.springboot_challenge01.repositories;

import compass.springboot_challenge01.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

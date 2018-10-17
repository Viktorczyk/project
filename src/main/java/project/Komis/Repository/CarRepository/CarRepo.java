package project.Komis.Repository.CarRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Komis.Model.PrepareCar.Car;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Integer> {

}

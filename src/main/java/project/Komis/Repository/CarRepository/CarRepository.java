package project.Komis.Repository.CarRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import project.Komis.Model.PrepareCar.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {

    @Query("select v from Car v where  v.sell = false")
    List<Car> findNotSoldCar();

}

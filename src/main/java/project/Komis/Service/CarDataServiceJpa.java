package project.Komis.Service;

import org.springframework.stereotype.Service;
import project.Komis.Model.PrepareCar.Car;

import java.util.List;

@Service
public interface CarDataServiceJpa {

    List<Car> findAllBySellIsFalse();

    Car loadCarById(Integer carID);

    public void deleteCar(Integer carId);

}

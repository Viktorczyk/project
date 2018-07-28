package project.Komis.Repository.CarRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Komis.Model.PrepareCar.Fuel;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {

    /*wybór nazwy */
    Fuel getFuelByTypeFuel (String typeName);



}

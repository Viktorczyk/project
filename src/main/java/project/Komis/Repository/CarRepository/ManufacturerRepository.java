package project.Komis.Repository.CarRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Komis.Model.PrepareCar.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

    Manufacturer getManufacturerByName(String name);

    Manufacturer getManufacturerById(Integer manufacturerId);

}

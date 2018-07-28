package project.Komis.Repository.CarRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Komis.Model.PrepareCar.GearBox;

public interface GearBoxRepository extends JpaRepository<GearBox, Integer> {

    GearBox getGearBoxByTypeGearBox(String typeGearBox);
}

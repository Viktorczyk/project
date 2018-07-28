package project.Komis.Repository.CarRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Komis.Model.PrepareCar.BodyType;

public interface BodyTypeRepository extends JpaRepository<BodyType, Integer> {

    BodyType getBodyTypeByBody(String bodyName);

}

package project.Komis.Repository.CarRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Komis.Model.PrepareCar.Model;

import javax.persistence.criteria.CriteriaBuilder;

public interface ModelRepository extends JpaRepository<Model, Integer> {

Model getModelByName(String modelName);

}

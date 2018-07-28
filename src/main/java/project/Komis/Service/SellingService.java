package project.Komis.Service;

import project.Komis.Model.Person;
import project.Komis.Model.Purchase;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface SellingService {

    Purchase sellCar(Integer sellCarId, Person person, Integer price);

    List<Purchase> getAllSales();

    Purchase getByIdService(Integer purchaseId );
}

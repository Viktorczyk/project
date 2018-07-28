package project.Komis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Komis.Model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}

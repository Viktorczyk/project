package project.Komis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Komis.Model.Client;
import project.Komis.Model.Person;

import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Person> findByPesel(Integer pesel);
}

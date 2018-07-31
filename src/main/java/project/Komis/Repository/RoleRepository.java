package project.Komis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Komis.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

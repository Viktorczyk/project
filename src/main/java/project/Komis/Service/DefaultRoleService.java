package project.Komis.Service;

import org.springframework.stereotype.Service;
import project.Komis.Model.Role;
import project.Komis.Repository.RoleRepository;

import java.util.List;

@Service
public class DefaultRoleService implements RoleService {

    private final RoleRepository roleRepository;

    public DefaultRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(Role newRole) {
        return roleRepository.save(newRole);
    }
}

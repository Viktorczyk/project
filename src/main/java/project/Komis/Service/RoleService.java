package project.Komis.Service;

import project.Komis.Model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRole();

    Role addRole(Role newRole);
}

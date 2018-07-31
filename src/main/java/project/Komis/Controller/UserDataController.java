package project.Komis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.Komis.Model.Role;
import project.Komis.Service.RoleService;

import java.util.List;

@Controller
@RequestMapping("/komis")
public class UserDataController {

    private final RoleService roleService;

    public UserDataController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/role")
    public String addRole(Model model){
        model.addAttribute("addRole", new Role());
        List<Role> roleList = roleService.getAllRole();
        model.addAttribute("allRole", roleList);
        return "pages/role";
    }

    @PostMapping("/role")
    public String saveRole(
            @ModelAttribute("addRole")
            Role roleToSave){
        Role role = new Role();
        role.setRoleType(roleToSave.getRoleType());
        roleService.addRole(roleToSave);
        return "redirect:/komis/role";
    }


}

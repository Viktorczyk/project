package project.Komis.Model;

import javax.persistence.Entity;

@Entity
public class Role extends BaseModel{

    private String roleType;

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}

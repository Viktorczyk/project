package project.Komis.Model.PrepareCar;

import project.Komis.Model.BaseModel;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Manufacturer extends BaseModel implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

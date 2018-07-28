package project.Komis.Model.PrepareCar;

import project.Komis.Model.BaseModel;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Fuel extends BaseModel implements Serializable {

    private String typeFuel;

    public String getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(String typeFuel) {
        this.typeFuel = typeFuel;
    }
}

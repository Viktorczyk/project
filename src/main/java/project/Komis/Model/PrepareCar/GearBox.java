package project.Komis.Model.PrepareCar;

import project.Komis.Model.BaseModel;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class GearBox extends BaseModel implements Serializable {

    private String typeGearBox;

    public String getTypeGearBox() {
        return typeGearBox;
    }

    public void setTypeGearBox(String typeGearBox) {
        this.typeGearBox = typeGearBox;
    }
}

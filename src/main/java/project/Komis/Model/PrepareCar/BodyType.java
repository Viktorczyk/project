package project.Komis.Model.PrepareCar;

import project.Komis.Model.BaseModel;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class BodyType extends BaseModel implements Serializable {

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }



}

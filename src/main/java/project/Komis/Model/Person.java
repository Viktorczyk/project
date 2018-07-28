package project.Komis.Model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Person extends Client implements Serializable {

    private String firstname;

    private String lastname;

    private int pesel;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }
}

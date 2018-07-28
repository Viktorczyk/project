package project.Komis.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
public class Purchase extends Transaction implements Serializable {

    @ManyToOne
    @JoinColumn(name = "clientWhoBuy_Id")
    private Client clientWhoBuy;

    private String seller;

    @Transient
    private String classname = Purchase.class.getSimpleName();

    public String getClassname() {
        return classname;
    }

    public Client getClientWhoBuy() {
        return clientWhoBuy;
    }

    public void setClientWhoBuy(Client clientWhoBuy) {
        this.clientWhoBuy = clientWhoBuy;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}




package project.Komis.Model;

import org.springframework.format.annotation.DateTimeFormat;
import project.Komis.Model.PrepareCar.Car;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public abstract class Transaction extends BaseModel implements Serializable {

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Integer price;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

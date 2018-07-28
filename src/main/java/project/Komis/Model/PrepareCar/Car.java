package project.Komis.Model.PrepareCar;

import groovy.transform.builder.Builder;
import project.Komis.Model.BaseModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Builder
@Entity
public class Car extends BaseModel implements Serializable {

    @JoinColumn(name = "id_manufacturer")
    @OneToOne(cascade = CascadeType.ALL)
    private Manufacturer manufacturer;


    @JoinColumn(name ="id_model" )
    @OneToOne(cascade = CascadeType.ALL)
    private Model model;

    @JoinColumn(name ="id_bodyType" )
    @OneToOne(cascade = CascadeType.ALL)
    private BodyType bodyType;

    @JoinColumn(name ="id_gearBox" )
    @OneToOne(cascade = CascadeType.ALL)
    private GearBox gearBox;

    @JoinColumn(name ="id_fuel" )
    @OneToOne(cascade = CascadeType.ALL)
    private Fuel fuel;

    private TypeCar typeCar;

    private String VIN;

    private Integer yearProduction;

    private String numberInsurance;

    private String numberPlate;

    private Long mileage;

    private String engine;

    private Integer power;

    private String text;

    private Integer numberTestDrive;

    private Integer price;

    private Boolean sell;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public TypeCar getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(TypeCar typeCar) {
        this.typeCar = typeCar;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public Integer getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Integer yearProduction) {
        this.yearProduction = yearProduction;
    }

    public String getNumberInsurance() {
        return numberInsurance;
    }

    public void setNumberInsurance(String numberInsurance) {
        this.numberInsurance = numberInsurance;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNumberTestDrive() {
        return numberTestDrive;
    }

    public void setNumberTestDrive(Integer numberTestDrive) {
        this.numberTestDrive = numberTestDrive;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getSell() {
        return sell;
    }

    public void setSell(Boolean sell) {
        this.sell = sell;
    }
}

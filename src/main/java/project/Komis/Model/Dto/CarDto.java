package project.Komis.Model.Dto;

import groovy.transform.builder.Builder;
import org.hibernate.validator.constraints.Length;
import project.Komis.Model.PrepareCar.Model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
public class CarDto {


    @NotNull(message ="Wybierz markę")
    private String model;

    @NotNull(message ="Wybierz model")
    private Integer manufacturer;

    @NotNull(message ="Podaj typ nadwozia")
    private Integer bodyType;

    @NotNull(message ="Wybierz skrzynię biegów")
    private Integer gearBox;

    @NotNull(message ="Podaj rodzaj paliwa")
    private Integer fuel;

    @NotNull(message ="Wybierz typ pojazdu")
    private Integer typeCar;


    @Size(min=3, message ="Podaj VIN")
    private String VIN;

    @NotNull(message="Podaj rocznik")
    @Min(value=1910, message="Za stare auto")
    @Max(value=2018, message="Auto z przyszłości")
    private Integer yearProduction;

    private String numberPlate;

    private String numberInsurance;

    private Long mileage;

    private String engine;

    private Integer power;

    @Length(max=250)
    @Size(min=5, message="Zbyt długi tekst")
    private String text;

    private Integer numberTestDrive;

    @NotNull(message = "Wprowadź kwote")
    private Integer price;

    private Boolean sell;


    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(@NotNull String model) {
        this.model = model;
    }

    @NotNull
    public Integer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(@NotNull Integer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @NotNull
    public Integer getBodyType() {
        return bodyType;
    }

    public void setBodyType(@NotNull Integer bodyType) {
        this.bodyType = bodyType;
    }

    @NotNull
    public Integer getGearBox() {
        return gearBox;
    }

    public void setGearBox(@NotNull Integer gearBox) {
        this.gearBox = gearBox;
    }

    @NotNull
    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(@NotNull Integer fuel) {
        this.fuel = fuel;
    }

    @NotNull
    public Integer getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(@NotNull Integer typeCar) {
        this.typeCar = typeCar;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    @NotNull
    public Integer getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(@NotNull Integer yearProduction) {
        this.yearProduction = yearProduction;
    }

    public String getNumberInsurance() {
        return numberInsurance;
    }

    public void setNumberInsurance(String numberInsurance) {
        this.numberInsurance = numberInsurance;
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

    @NotNull
    public Integer getPrice() {
        return price;
    }

    public void setPrice(@NotNull Integer price) {
        this.price = price;
    }

    public Boolean getSell() {
        return sell;
    }

    public void setSell(Boolean sell) {
        this.sell = sell;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

}

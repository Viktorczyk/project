package project.Komis.Model.Dto;

import groovy.transform.builder.Builder;

@Builder
public class ModelDto {

     private String model;


     private Integer manufacturer;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Integer manufacturer) {
        this.manufacturer = manufacturer;
    }
}

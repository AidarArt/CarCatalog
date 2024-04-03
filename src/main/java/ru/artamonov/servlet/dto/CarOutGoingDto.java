package ru.artamonov.servlet.dto;

import java.util.List;

public class CarOutGoingDto {
    private String model;
    private BrandOutGoingDto brand;
    private List<CreatorOutGoingDto> creators;

    public CarOutGoingDto() {
    }

    public CarOutGoingDto(String model, BrandOutGoingDto brand, List<CreatorOutGoingDto> creators) {
        this.model = model;
        this.brand = brand;
        this.creators = creators;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BrandOutGoingDto getBrand() {
        return brand;
    }

    public void setBrand(BrandOutGoingDto brand) {
        this.brand = brand;
    }

    public List<CreatorOutGoingDto> getCreators() {
        return creators;
    }

    public void setCreators(List<CreatorOutGoingDto> creators) {
        this.creators = creators;
    }
}

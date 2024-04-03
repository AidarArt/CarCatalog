package ru.artamonov.servlet.dto;

import java.util.List;

public class BrandOutGoingDto {
    private String name;
    private String country;
    private List<CarOutGoingDto> cars;

    public BrandOutGoingDto() {
    }

    public BrandOutGoingDto(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public List<CarOutGoingDto> getCars() {
        return cars;
    }

    public void setCars(List<CarOutGoingDto> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

package ru.artamonov.servlet.dto;

import java.util.List;

public class CreatorOutGoingDto {
    private String name;
    private String surname;
    private String profession;
    private List<CarOutGoingDto> cars;

    public CreatorOutGoingDto() {
    }

    public CreatorOutGoingDto(String name, String surname, String profession, List<CarOutGoingDto> cars) {
        this.name = name;
        this.surname = surname;
        this.profession = profession;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<CarOutGoingDto> getCars() {
        return cars;
    }

    public void setCars(List<CarOutGoingDto> cars) {
        this.cars = cars;
    }
}

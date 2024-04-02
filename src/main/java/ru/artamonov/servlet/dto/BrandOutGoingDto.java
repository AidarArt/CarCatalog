package ru.artamonov.servlet.dto;

public class BrandOutGoingDto {
    private String id;
    private String name;
    private String country;

    public BrandOutGoingDto() {
    }

    public BrandOutGoingDto(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Brand {" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}' + '\n';
    }
}

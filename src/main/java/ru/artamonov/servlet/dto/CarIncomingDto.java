package ru.artamonov.servlet.dto;

public class CarIncomingDto {

    private Long id;
    private String model;
    private Long brandId;

    public CarIncomingDto() {
    }

    public CarIncomingDto(Long id, String model, Long brandId) {
        this.id = id;
        this.model = model;
        this.brandId = brandId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}

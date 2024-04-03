package ru.artamonov.model;

import java.util.List;

public class BrandEntity {
    private Long brandId;
    private String brandName;
    private String brandCountry;
    private List<CarEntity> brandCars;

    public BrandEntity() {
    }

    public BrandEntity(Long brandId, String brandName, String brandCountry, List<CarEntity> brandCars) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandCountry = brandCountry;
        this.brandCars = brandCars;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }

    public List<CarEntity> getBrandCars() {
        return brandCars;
    }

    public void setBrandCars(List<CarEntity> brandCars) {
        this.brandCars = brandCars;
    }
}

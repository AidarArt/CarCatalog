package ru.artamonov.model;

import ru.artamonov.model.enums.Country;

import java.util.List;

public class BrandEntity {
    private Long brandId;
    private String brandName;
    private Country brandCountry;
    private List<EngineEntity> brandEngines;

    private List<CarEntity> brandCars;

    public BrandEntity() {
    }

    public BrandEntity(Long brandId, String brandName, Country brandCountry) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandCountry = brandCountry;
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

    public Country getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(Country brandCountry) {
        this.brandCountry = brandCountry;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", brandCountry=" + brandCountry +
                ", brandEngines=" + brandEngines +
                ", brandCars=" + brandCars +
                '}';
    }
}

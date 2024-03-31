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

    public BrandEntity(Long brandId, String brandName, Country brandCountry,
                       List<EngineEntity> brandEngines, List<CarEntity> brandCars) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandCountry = brandCountry;
        this.brandEngines = brandEngines;
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

    public Country getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(Country brandCountry) {
        this.brandCountry = brandCountry;
    }

    public List<EngineEntity> getBrandEngines() {
        return brandEngines;
    }

    public void setBrandEngines(List<EngineEntity> brandEngines) {
        this.brandEngines = brandEngines;
    }

    public List<CarEntity> getBrandCars() {
        return brandCars;
    }

    public void setBrandCars(List<CarEntity> brandCars) {
        this.brandCars = brandCars;
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

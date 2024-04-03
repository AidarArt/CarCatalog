package ru.artamonov.model;

import java.util.List;

public class CarEntity {
    private Long carId;
    private BrandEntity carBrand;
    private String carModelName;
    private List<CreatorEntity> carCreators;

    public CarEntity() {
    }

    public CarEntity(Long carId, BrandEntity carBrand, String carModelName, List<CreatorEntity> carCreators) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModelName = carModelName;
        this.carCreators = carCreators;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public BrandEntity getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(BrandEntity carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public List<CreatorEntity> getCarCreators() {
        return carCreators;
    }

    public void setCarCreators(List<CreatorEntity> carCreators) {
        this.carCreators = carCreators;
    }

    public void addCreator(CreatorEntity creatorEntity) {
        carCreators.add(creatorEntity);
    }
}

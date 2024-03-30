package ru.artamonov.model;

import ru.artamonov.model.enums.BodyType;
import ru.artamonov.model.enums.Transmission;

import java.util.List;

public class CarEntity {
    private Long carId;
    private BrandEntity carBrand;
    private EngineEntity carEngine;
    private double carAccelerationTo100;
    private double carMaxSpeed;
    private Transmission carTransmission;
    private BodyType carBodyType;
    private List<CreatorEntity> carCreators;

    public CarEntity() {
    }

    public CarEntity(Long carId, BrandEntity carBrand, EngineEntity carEngine, double carAccelerationTo100, double carMaxSpeed, Transmission carTransmission, BodyType carBodyType) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carEngine = carEngine;
        this.carAccelerationTo100 = carAccelerationTo100;
        this.carMaxSpeed = carMaxSpeed;
        this.carTransmission = carTransmission;
        this.carBodyType = carBodyType;
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

    public EngineEntity getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(EngineEntity carEngine) {
        this.carEngine = carEngine;
    }

    public double getCarAccelerationTo100() {
        return carAccelerationTo100;
    }

    public void setCarAccelerationTo100(double carAccelerationTo100) {
        this.carAccelerationTo100 = carAccelerationTo100;
    }

    public double getCarMaxSpeed() {
        return carMaxSpeed;
    }

    public void setCarMaxSpeed(double carMaxSpeed) {
        this.carMaxSpeed = carMaxSpeed;
    }

    public Transmission getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(Transmission carTransmission) {
        this.carTransmission = carTransmission;
    }

    public BodyType getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(BodyType carBodyType) {
        this.carBodyType = carBodyType;
    }
}

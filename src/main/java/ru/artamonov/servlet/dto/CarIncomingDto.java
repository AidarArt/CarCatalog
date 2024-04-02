package ru.artamonov.servlet.dto;

import java.util.List;

public class CarIncomingDto {
    private String id;
    private String carModelName;
    private String brandName;
    private String brandCountry;
    private String engineBrand;
    private String engineBrandCountry;
    private String engineCapacity;
    private String engineHorsePower;
    private String engineCylindersNumber;
    private String engineConsumption;
    private String engineType;
    private String carAccelerationTo100;
    private String carMaxSpeed;
    private String carTransmission;
    private String carBodyType;
    private List<String> carCreators;

    public String getId() {
        return id;
    }

    public String getEngineBrandCountry() {
        return engineBrandCountry;
    }

    public void setEngineBrandCountry(String engineBrandCountry) {
        this.engineBrandCountry = engineBrandCountry;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEngineBrand() {
        return engineBrand;
    }

    public void setEngineBrand(String engineBrand) {
        this.engineBrand = engineBrand;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getEngineHorsePower() {
        return engineHorsePower;
    }

    public void setEngineHorsePower(String engineHorsePower) {
        this.engineHorsePower = engineHorsePower;
    }

    public String getEngineCylindersNumber() {
        return engineCylindersNumber;
    }

    public void setEngineCylindersNumber(String engineCylindersNumber) {
        this.engineCylindersNumber = engineCylindersNumber;
    }

    public String getEngineConsumption() {
        return engineConsumption;
    }

    public void setEngineConsumption(String engineConsumption) {
        this.engineConsumption = engineConsumption;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarAccelerationTo100() {
        return carAccelerationTo100;
    }

    public void setCarAccelerationTo100(String carAccelerationTo100) {
        this.carAccelerationTo100 = carAccelerationTo100;
    }

    public String getCarMaxSpeed() {
        return carMaxSpeed;
    }

    public void setCarMaxSpeed(String carMaxSpeed) {
        this.carMaxSpeed = carMaxSpeed;
    }

    public String getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    public String getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(String carBodyType) {
        this.carBodyType = carBodyType;
    }

    public List<String> getCarCreators() {
        return carCreators;
    }

    public void setCarCreators(List<String> carCreators) {
        this.carCreators = carCreators;
    }
}

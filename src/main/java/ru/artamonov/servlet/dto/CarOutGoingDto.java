package ru.artamonov.servlet.dto;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.model.EngineEntity;
import ru.artamonov.model.enums.BodyType;
import ru.artamonov.model.enums.Transmission;

import java.util.List;

public class CarOutGoingDto {
    private String carBrand;
    private String carEngine;
    private String carModelName;
    private String carAccelerationTo100;
    private String carMaxSpeed;
    private String carTransmission;
    private String carBodyType;
    private List<String> carCreators;

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
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

    @Override
    public String toString() {
        return "Car {\n" +
                "carBrand='\n" + carBrand + '\'' +
                ", carEngine='\n" + carEngine + '\'' +
                ", \n carModelName='" + carModelName + '\'' +
                ", \n carAccelerationTo100='" + carAccelerationTo100 + '\'' +
                ", \n carMaxSpeed='" + carMaxSpeed + '\'' +
                ", \n carTransmission='" + carTransmission + '\'' +
                ", \n carBodyType='" + carBodyType + '\'' +
                ", \n carCreators=" + carCreators +
                "\n}" + '\n';
    }
}

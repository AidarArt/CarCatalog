package ru.artamonov.model;

import ru.artamonov.model.enums.EngineType;

import java.util.List;

public class EngineEntity {
    private Long engineId;
    private BrandEntity brand;
    private double engineCapacity;
    private double engineHorsePower;
    private int engineCylindersNumber;
    private double engineConsumption;
    private EngineType engineType;
    private List<CarEntity> engineCars;

    public EngineEntity() {
    }

    public EngineEntity(Long engineId, BrandEntity brand, double engineCapacity, double engineHorsePower,
                        int engineCylindersNumber, double engineConsumption, List<CarEntity> engineCars) {
        this.engineId = engineId;
        this.brand = brand;
        this.engineCapacity = engineCapacity;
        this.engineHorsePower = engineHorsePower;
        this.engineCylindersNumber = engineCylindersNumber;
        this.engineConsumption = engineConsumption;
        this.engineCars = engineCars;
    }

    public Long getEngineId() {
        return engineId;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double getEngineHorsePower() {
        return engineHorsePower;
    }

    public void setEngineHorsePower(double engineHorsePower) {
        this.engineHorsePower = engineHorsePower;
    }

    public int getEngineCylindersNumber() {
        return engineCylindersNumber;
    }

    public void setEngineCylindersNumber(int engineCylindersNumber) {
        this.engineCylindersNumber = engineCylindersNumber;
    }

    public double getEngineConsumption() {
        return engineConsumption;
    }

    public void setEngineConsumption(double engineConsumption) {
        this.engineConsumption = engineConsumption;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public List<CarEntity> getEngineCars() {
        return engineCars;
    }

    public void setEngineCars(List<CarEntity> engineCars) {
        this.engineCars = engineCars;
    }

    @Override
    public String toString() {
        return "EngineEntity\n{" +
                "\nengineId=" + engineId +
                ", \nbrand=" + brand +
                ", \nengineCapacity=" + engineCapacity +
                ", \nengineHorsePower=" + engineHorsePower +
                ", \nengineCylindersNumber=" + engineCylindersNumber +
                ", \nengineConsumption=" + engineConsumption +
                ", \nengineType=" + engineType +
                "\n}";
    }
}

package ru.artamonov.model;

import java.util.List;

public class CreatorEntity {
    private Long creatorId;
    private String creatorName;
    private String creatorSurname;
    private String creatorProfession;
    private List<CarEntity> creatorCars;

    public CreatorEntity() {
    }

    public CreatorEntity(Long creatorId, String creatorName, String creatorSurname, String creatorProfession, List<CarEntity> creatorCars) {
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.creatorSurname = creatorSurname;
        this.creatorProfession = creatorProfession;
        this.creatorCars = creatorCars;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorSurname() {
        return creatorSurname;
    }

    public void setCreatorSurname(String creatorSurname) {
        this.creatorSurname = creatorSurname;
    }

    public String getCreatorProfession() {
        return creatorProfession;
    }

    public void setCreatorProfession(String creatorProfession) {
        this.creatorProfession = creatorProfession;
    }

    public List<CarEntity> getCreatorCars() {
        return creatorCars;
    }

    public void setCreatorCars(List<CarEntity> creatorCars) {
        this.creatorCars = creatorCars;
    }
}

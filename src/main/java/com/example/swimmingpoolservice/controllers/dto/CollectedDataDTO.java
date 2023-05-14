package com.example.swimmingpoolservice.controllers.dto;

import java.time.ZonedDateTime;
import java.util.Date;

public class CollectedDataDTO {

    private Integer amountPeopleAtPool;
    private Integer amountOfFreeSpotsAtPool;
    private Integer amountPeopleAtSpa;
    private Integer amountOfFreeSpotsAtSpa;

    private ZonedDateTime downloadDate;

    public CollectedDataDTO() {

    }


    @Override
    public String toString() {
        return "CollectedDataDTO{" +
                "amountPeopleAtPool=" + amountPeopleAtPool +
                ", amountOfFreeSpotsAtPool=" + amountOfFreeSpotsAtPool +
                ", amountPeopleAtSpa=" + amountPeopleAtSpa +
                ", amountOfFreeSpotsAtSpa=" + amountOfFreeSpotsAtSpa +
                ", downloadDate=" + downloadDate +
                '}';
    }

    public CollectedDataDTO(Integer amountPeopleAtPool, Integer amountOfFreeSpotsAtPool, Integer amountPeopleAtSpa, Integer amountOfFreeSpotsAtSpa, ZonedDateTime downloadDate) {
        this.amountPeopleAtPool = amountPeopleAtPool;
        this.amountOfFreeSpotsAtPool = amountOfFreeSpotsAtPool;
        this.amountPeopleAtSpa = amountPeopleAtSpa;
        this.amountOfFreeSpotsAtSpa = amountOfFreeSpotsAtSpa;
        this.downloadDate = downloadDate;
    }

    public Integer getAmountPeopleAtPool() {
        return amountPeopleAtPool;
    }

    public void setAmountPeopleAtPool(Integer amountPeopleAtPool) {
        this.amountPeopleAtPool = amountPeopleAtPool;
    }

    public Integer getAmountOfFreeSpotsAtPool() {
        return amountOfFreeSpotsAtPool;
    }

    public void setAmountOfFreeSpotsAtPool(Integer amountOfFreeSpotsAtPool) {
        this.amountOfFreeSpotsAtPool = amountOfFreeSpotsAtPool;
    }

    public Integer getAmountPeopleAtSpa() {
        return amountPeopleAtSpa;
    }

    public void setAmountPeopleAtSpa(Integer amountPeopleAtSpa) {
        this.amountPeopleAtSpa = amountPeopleAtSpa;
    }

    public Integer getAmountOfFreeSpotsAtSpa() {
        return amountOfFreeSpotsAtSpa;
    }

    public void setAmountOfFreeSpotsAtSpa(Integer amountOfFreeSpotsAtSpa) {
        this.amountOfFreeSpotsAtSpa = amountOfFreeSpotsAtSpa;
    }

    public ZonedDateTime getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(ZonedDateTime downloadDate) {
        this.downloadDate = downloadDate;
    }

}

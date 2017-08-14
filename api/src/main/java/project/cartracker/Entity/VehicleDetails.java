package project.cartracker.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.UUID;

@Entity
public class VehicleDetails {

        @Id
        private String vin;
        private  String make;
        private  String model;
        private  Integer year;
        private  Integer redlineRpm;
        private Integer maxFuelVolume;
        private  String lastServiceDate;

/*    @OneToOne
    @JoinColumn(name = "vehicle_id"
    private NewVehicle newVehicle;*/

    public VehicleDetails(){
        /*this.id= UUID.randomUUID().toString();*/
    }
/*
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }*/

 /*   public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(Integer redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public Integer getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(Integer maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

/*    public NewVehicle getNewVehicle() {
        return newVehicle;
    }

    public void setNewVehicle(NewVehicle newVehicle) {
        this.newVehicle = newVehicle;
    }*/
}

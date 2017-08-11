package project.cartracker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
public class VehicleDetails {

        @Id
        private String id;
        private String vin;
        private  String make;
        private  String model;
        private  int year;
        private  int redlineRpm;
        private  int maxFuelVolume;
        private  String lastServiceDate;

        @OneToOne
        private NewVehicle newVehicle;

    public VehicleDetails(){
        this.id= UUID.randomUUID().toString();
    }
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public NewVehicle getNewVehicle() {
        return newVehicle;
    }

    public void setNewVehicle(NewVehicle newVehicle) {
        this.newVehicle = newVehicle;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}

package project.cartracker.Entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "VehicleDetails.findByVin", query = "SELECT vehicle FROM VehicleDetails vehicle where vehicle.vin=:paramvin")
})
public class VehicleDetails {

        @Id
        @Column(name = "Vehicle_Id",columnDefinition = "VARCHAR(17)")
        private String vin;
        @Column(name = "Make",columnDefinition = "VARCHAR(15)")
        private  String make;
        @Column(name = "Model",columnDefinition = "VARCHAR(15)")
        private  String model;
        @Column(name = "Year",columnDefinition = "INT(4)")
        private  Integer year;
        @Column(name = "RedLineRPM",columnDefinition = "INT(4)")
        private  Integer redlineRpm;
        @Column(name = "MaxFuelVolume",columnDefinition = "INT(2)")
        private Integer maxFuelVolume;
        @Column(name = "LastServiceDate")
        private  String lastServiceDate;


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

}

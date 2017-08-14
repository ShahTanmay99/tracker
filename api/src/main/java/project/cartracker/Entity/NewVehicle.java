package project.cartracker.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQueries({
        @NamedQuery(name = "NewVehicle.findByVin", query = "SELECT vehicle FROM NewVehicle vehicle where vehicle.vin=:paramvin")
})
public class NewVehicle{

    @Id
    @Column(name = "Vehicle_Id",columnDefinition = "VARCHAR(17)")
    private String vin;
    @Column(name = "Latitude")
    private float latitude;
    @Column(name = "Longitude")
    private float longitude;
    @Column(name = "Timestamp")
    private Timestamp timestamp;
    @Column(name = "FuelVolume")
    private float fuelVolume;
    @Column(name = "Speed",columnDefinition = "INT(3)")
    private int speed;
    @Column(name = "Engine_HP",columnDefinition = "INT(3)")
    private int engineHp;
    @Column(name = "Engine_Light")
    private boolean checkEngineLightOn;
    @Column(name = "Engine_Coolant")
    private boolean engineCoolantLow;
    @Column(name = "Cruise_Control")
    private boolean cruiseControlOn;
    @Column(name = "Engine_RPM",columnDefinition = "INTEGER(4)")
    private int engineRpm;

    @OneToOne
    private Alerts alerts;

    @OneToOne
    private Tire tires;

    public NewVehicle(){
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Alerts getAlerts() {
        return alerts;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

    public Tire getTires() {
        return tires;
    }

    public void setTires(Tire tires) {
        this.tires = tires;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public float getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(float fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        if (checkEngineLightOn)
        this.checkEngineLightOn = true;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }
}

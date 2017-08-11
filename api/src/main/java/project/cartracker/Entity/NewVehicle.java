package project.cartracker.Entity;

import sun.plugin.util.UIUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
public class NewVehicle{

    @Id
    private String id;
    private String vin;
    private float latitude;
    private float longitude;
    private String timestamp;
    private float fuelVolume;
    private int speed;
    private int engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private int engineRpm;
    private String CoolantandLightAlert;
    private String rpmAlert;
    private String tireAlert;
    private String fuelAlert;
    public NewVehicle(){
        this.id = UUID.randomUUID().toString();
    }
    //private Map<String, Integer> tires;
/*
    @OneToOne
    private Tyre tires;*//*

    public Tyre getTires() {
        return tires;
    }

    public void setTires(Tyre tires) {
        this.tires = tires;
    }*/

/*    public Map<String, Integer> getTires() {
        return tires;
    }

    public void setTires(Map<String, Integer> tires) {
        this.tires = tires;
    }*/

    public String getRpmAlert() {
        return rpmAlert;
    }

    public void setRpmAlert(String rpmAlert) {
        this.rpmAlert = rpmAlert;
    }

    public String getTireAlert() {
        return tireAlert;
    }

    public void setTireAlert(String tireAlert) {
        this.tireAlert = tireAlert;
    }

    public String getFuelAlert() {
        return fuelAlert;
    }

    public void setFuelAlert(String fuelAlert) {
        this.fuelAlert = fuelAlert;
    }

    public String getCoolantandLightAlert() {
        return CoolantandLightAlert;
    }

    public void setCoolantandLightAlert(String coolantandLightAlert) {
        this.CoolantandLightAlert = coolantandLightAlert;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
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

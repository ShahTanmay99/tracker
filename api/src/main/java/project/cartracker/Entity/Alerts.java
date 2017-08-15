package project.cartracker.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Alerts {

    @Id
    @Column(name = "Alert_Id",columnDefinition = "VARCHAR(36)")
    private String id;
    @Column(name = "CoolantAndLightAlert",columnDefinition = "VARCHAR(8)")
    private String CoolantandLightAlert;
    @Column(name = "RPM_Alert",columnDefinition = "VARCHAR(8)")
    private String rpmAlert;
    @Column(name = "TireAlert",columnDefinition = "VARCHAR(8)")
    private String tireAlert;
    @Column(name = "FuelAlert",columnDefinition = "VARCHAR(8)")
    private String fuelAlert;

    public Alerts(){
        this.id= UUID.randomUUID().toString();
    }

    public String getCoolantandLightAlert() {
        return CoolantandLightAlert;
    }

    public void setCoolantandLightAlert(String coolantandLightAlert) {
        CoolantandLightAlert = coolantandLightAlert;
    }

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
}

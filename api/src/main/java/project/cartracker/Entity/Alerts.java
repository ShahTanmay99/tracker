package project.cartracker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Alerts {

    @Id
    private String id;
    private String CoolantandLightAlert;
    private String rpmAlert;
    private String tireAlert;
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

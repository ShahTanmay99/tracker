package project.cartracker.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Tire {
    @Id
    @Column(name = "Tyre_Id",columnDefinition = "VARCHAR(36)")
    private String id;
    @Column(name = "FrontLeft",columnDefinition = "INT(2)")
    private int frontLeft;
    @Column(name = "FrontRight",columnDefinition = "INT(2)")
    private int frontRight;
    @Column(name = "RearLeft",columnDefinition = "INT(2)")
    private int rearLeft;
    @Column(name = "RearRight",columnDefinition = "INT(2)")
    private int rearRight;

    public Tire(){
        this.id =UUID.randomUUID().toString();
    }
    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }
}

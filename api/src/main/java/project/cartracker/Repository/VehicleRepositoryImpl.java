package project.cartracker.Repository;

import org.springframework.stereotype.Repository;
import project.cartracker.Entity.Alerts;
import project.cartracker.Entity.NewVehicle;
import project.cartracker.Entity.VehicleDetails;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext private EntityManager entityManager;
    public NewVehicle postVehicle(NewVehicle newVehicle, Alerts alerts) {
        List<NewVehicle> list = new ArrayList<NewVehicle>();
        list.add(newVehicle);

            entityManager.persist(list.get(0).getTires());
            entityManager.persist(list.get(0));
            entityManager.persist(alerts);

        return newVehicle;
    }

    public VehicleDetails findbyVin(String vin) {
        TypedQuery<VehicleDetails> query = entityManager.createNamedQuery("VehicleDetails.findByVin", VehicleDetails.class);
        query.setParameter("paramvin", vin);
        List<VehicleDetails> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
    public NewVehicle findbyVid(String vin) {
        TypedQuery<NewVehicle> query = entityManager.createNamedQuery("NewVehicle.findByVin", NewVehicle.class);
        query.setParameter("paramvin", vin);
        List<NewVehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        }else {
            return null;
        }
    }
    public VehicleDetails updateVehicle(ArrayList<VehicleDetails> vehicleDetails) {
            entityManager.merge(vehicleDetails.get(0));
        return vehicleDetails.get(0);
    }

    public NewVehicle updateVehicle(NewVehicle newVehicle) {
        entityManager.merge(newVehicle);
        return newVehicle;
    }

    public VehicleDetails putVehicle(ArrayList<VehicleDetails> vehicleDetails) {
        entityManager.persist(vehicleDetails.get(0));
        return vehicleDetails.get(0);
    }
    public Alerts checkAlerts(NewVehicle vehicle) {
        Alerts alerts = new Alerts();
        VehicleDetails existing = findbyVin(vehicle.getVin());
        checkRpmAlert(vehicle, existing, alerts);
        checkFuelAlert(vehicle,existing, alerts);
        checkTireAlert(vehicle, alerts);
        checkLightCoolantAlert(vehicle,alerts);
        return alerts;
    }
    public Alerts checkRpmAlert(NewVehicle vehicle, VehicleDetails existing, Alerts alerts) {
        alerts.setRpmAlert("NO ALERT");
        if (existing != null) {
            if (existing.getRedlineRpm() < vehicle.getEngineRpm())
               alerts.setRpmAlert("HIGH");
        }
        return alerts;
    }
    Alerts checkFuelAlert(NewVehicle vehicle, VehicleDetails existing, Alerts alerts){
        alerts.setFuelAlert("NO ALERT");
        if(existing != null) {
            if (vehicle.getFuelVolume() < ((0.1) * existing.getMaxFuelVolume()))
                alerts.setFuelAlert("MEDIUM");
        }
        return alerts;
    }
    Alerts checkTireAlert(NewVehicle vehicle,Alerts alerts){
        alerts.setTireAlert("NO ALERT");
        if((vehicle.getTires().getFrontLeft()<32)||(vehicle.getTires().getFrontLeft()>36))
            alerts.setTireAlert("LOW");
        else if((vehicle.getTires().getFrontRight()<32)||(vehicle.getTires().getFrontRight()>36))
            alerts.setTireAlert("LOW");
        else if((vehicle.getTires().getRearLeft()<32)||(vehicle.getTires().getRearRight()>36))
            alerts.setTireAlert("LOW");
        else if((vehicle.getTires().getRearRight()<32)||(vehicle.getTires().getRearRight()>36))
            alerts.setTireAlert("LOW");
        return alerts;
    }
    Alerts checkLightCoolantAlert(NewVehicle vehicle, Alerts alerts){
        alerts.setCoolantandLightAlert("NO ALERT");
        if(vehicle.isEngineCoolantLow() || vehicle.isCheckEngineLightOn())
            alerts.setCoolantandLightAlert("LOW");
        return alerts;
    }
}

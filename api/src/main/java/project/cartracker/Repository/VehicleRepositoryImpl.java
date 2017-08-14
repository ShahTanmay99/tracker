package project.cartracker.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.cartracker.Entity.Alerts;
import project.cartracker.Entity.NewVehicle;
import project.cartracker.Entity.VehicleDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext private EntityManager entityManager;
    public NewVehicle postVehicle(NewVehicle newVehicle, Alerts alerts) {

        ArrayList<NewVehicle> list = new ArrayList<NewVehicle>();
        if(list.size()==0)
        list.add(newVehicle);
        else {
            for (int i = 0; i < list.size(); i++) {
                //newVehicle = new NewVehicle();
                list.add(newVehicle);
            }
        }
/*        for(int i = 0; i<list.size(); i++){
            entityManager.persist(list.get(i));
        }*/

/*        if(list == null){

            for (int i =0; list)
        }
        list.add(newVehicle);
        for (int i=0; i<list.size();i++){
            entityManager.persist(list.ge


          t(i));
        }
*/
        entityManager.persist(list.get(0).getTires());
        entityManager.persist(alerts);
        entityManager.persist(list.get(0));
        return newVehicle;
    }

    public VehicleDetails findbyVin(String vin) {
        TypedQuery<VehicleDetails> query = entityManager.createQuery("SELECT vehicle FROM VehicleDetails vehicle where vehicle.vin=:paramvin", VehicleDetails.class);
        query.setParameter("paramvin", vin);
        List<VehicleDetails> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
    public NewVehicle findbyVid(String vin) {
        TypedQuery<NewVehicle> query = entityManager.createQuery("SELECT vehicle FROM NewVehicle vehicle where vehicle.vin=:paramvin", NewVehicle.class);
        query.setParameter("paramvin", vin);
        List<NewVehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
    public VehicleDetails updateVehicle(ArrayList<VehicleDetails> vehicleDetails) {
        entityManager.merge(vehicleDetails.get(0));
        return vehicleDetails.get(0);
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
        //entityManager.persist(alerts);
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

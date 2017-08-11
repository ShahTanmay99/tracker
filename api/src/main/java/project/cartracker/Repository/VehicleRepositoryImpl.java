package project.cartracker.Repository;

import org.springframework.stereotype.Repository;
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
    public NewVehicle postVehicle(NewVehicle newVehicle) {
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
            entityManager.persist(list.get(i));
        }

        checkAlerts(newVehicle);*/
        entityManager.persist(list.get(0).getTires());
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
    public VehicleDetails updateVehicle(VehicleDetails vehicleDetails,VehicleDetails existing) {
        entityManager.remove(existing);
        entityManager.persist(vehicleDetails);
        return vehicleDetails;
    }

    public VehicleDetails putVehicle(VehicleDetails vehicleDetails) {
        ArrayList<VehicleDetails> list = new ArrayList<VehicleDetails>();
        if(list.size()==0)
            list.add(vehicleDetails);
        else {
            for (int i = 0; i < list.size(); i++) {
                //newVehicle = new NewVehicle();
                list.add(vehicleDetails);
            }
        }
        entityManager.persist(list.get(0));
        return vehicleDetails;
    }

    public void checkAlerts(NewVehicle vehicle) {

        VehicleDetails existing = findbyVin(vehicle.getVin());
        checkRpmAlert(vehicle,existing);
        checkFuelAlert(vehicle,existing);
        checkTireAlert(vehicle);
        checkLightCoolantAlert(vehicle);
    }

    public void checkRpmAlert(NewVehicle vehicle, VehicleDetails existing) {
        vehicle.setRpmAlert("LOW");
        if (existing != null) {
            if (existing.getRedlineRpm() < vehicle.getEngineRpm())
                vehicle.setRpmAlert("HIGH");
        }
    }
    public void checkFuelAlert(NewVehicle vehicle, VehicleDetails existing){
        vehicle.setFuelAlert("LOW");
        if(existing != null) {
            if (vehicle.getFuelVolume() < ((0.1) * existing.getMaxFuelVolume()))
                vehicle.setFuelAlert("MEDIUM");
        }
    }
    public void checkTireAlert(NewVehicle vehicle){

    }
    public void checkLightCoolantAlert(NewVehicle vehicle){
        if(vehicle.isEngineCoolantLow() || vehicle.isCheckEngineLightOn())
            vehicle.setCoolantandLightAlert("LOW");
    }


/*    public NewVehicle findByVin(String vin) {

        TypedQuery<NewVehicle> query = entityManager.createNamedQuery("findByVin", NewVehicle.class);
        query.setParameter("paramVin", vin);
        List<NewVehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }*/

}

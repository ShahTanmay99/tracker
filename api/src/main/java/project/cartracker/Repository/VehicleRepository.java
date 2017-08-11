package project.cartracker.Repository;

import project.cartracker.Entity.NewVehicle;
import project.cartracker.Entity.VehicleDetails;

import java.util.List;

public interface VehicleRepository {
    NewVehicle postVehicle(NewVehicle newVehicle);
    NewVehicle findbyVid(String vin);
    VehicleDetails findbyVin(String vin);
    VehicleDetails updateVehicle(VehicleDetails vehicleDetails, VehicleDetails existing);
    VehicleDetails putVehicle(VehicleDetails vehicleDetails);
    void checkAlerts(NewVehicle vehicle);
}

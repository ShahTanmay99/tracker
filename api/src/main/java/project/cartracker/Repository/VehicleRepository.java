package project.cartracker.Repository;

import project.cartracker.Entity.Alerts;
import project.cartracker.Entity.NewVehicle;
import project.cartracker.Entity.VehicleDetails;

import java.util.ArrayList;

public interface VehicleRepository {
    NewVehicle postVehicle(NewVehicle newVehicle, Alerts alerts);
    NewVehicle findbyVid(String vin);
    VehicleDetails findbyVin(String vin);
    NewVehicle updateVehicle(NewVehicle newVehicle);
    VehicleDetails updateVehicle(ArrayList<VehicleDetails> vehicleDetails);
    VehicleDetails putVehicle(ArrayList<VehicleDetails> vehicleDetails);
    Alerts checkAlerts(NewVehicle vehicle);
}

package project.cartracker.Service;

import project.cartracker.Entity.NewVehicle;
import project.cartracker.Entity.VehicleDetails;

import java.util.List;

public interface VehicleService {
    NewVehicle postVehicle(NewVehicle newVehicle);
    VehicleDetails putVehicle(VehicleDetails putVehicle);
}

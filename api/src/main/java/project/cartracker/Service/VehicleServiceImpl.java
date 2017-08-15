package project.cartracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cartracker.Entity.Alerts;
import project.cartracker.Entity.NewVehicle;
import project.cartracker.Entity.VehicleDetails;
import project.cartracker.Exception.BadRequestException;
import project.cartracker.Repository.VehicleRepository;

import java.util.ArrayList;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;
    @Transactional
    public NewVehicle postVehicle(NewVehicle newVehicle) {
        Alerts alert = repository.checkAlerts(newVehicle);
        NewVehicle existing = repository.findbyVid(newVehicle.getVin());
        if (existing != null) {
            return repository.updateVehicle(newVehicle);
            //throw new BadRequestException("Vehicle with Id " + newVehicle.getVin() + " already exists.");
        }
        return repository.postVehicle(newVehicle, alert);
    }
    @Transactional
    public VehicleDetails putVehicle(ArrayList<VehicleDetails> vehicleDetails) {

        VehicleDetails existing = repository.findbyVin(vehicleDetails.get(0).getVin());
        if (existing != null) {
            return repository.updateVehicle(vehicleDetails);
        }
        return repository.putVehicle(vehicleDetails);
    }
}

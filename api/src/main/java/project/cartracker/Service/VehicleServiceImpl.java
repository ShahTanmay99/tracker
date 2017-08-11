package project.cartracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cartracker.Entity.NewVehicle;
import project.cartracker.Entity.VehicleDetails;
import project.cartracker.Exception.BadRequestException;
import project.cartracker.Exception.ResourceNotFoundException;
import project.cartracker.Repository.VehicleRepository;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;
    @Transactional
    public NewVehicle postVehicle(NewVehicle newVehicle) {
        //repository.checkAlerts(newVehicle);
/*        NewVehicle existing = repository.findByVin(newVehicle.getVin());
        if (existing != null) {
            throw new BadRequestException("Vehicle with Id " + newVehicle.getVin() + " already exists.");
        }*/
        return repository.postVehicle(newVehicle);
    }
    @Transactional
    public VehicleDetails putVehicle(VehicleDetails vehicleDetails) {

        VehicleDetails existing = repository.findbyVin(vehicleDetails.getVin());
        if (existing != null) {
            return repository.updateVehicle(vehicleDetails, existing);
        }
        return repository.putVehicle(vehicleDetails);
    }
}

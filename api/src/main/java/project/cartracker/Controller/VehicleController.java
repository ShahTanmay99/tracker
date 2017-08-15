package project.cartracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import project.cartracker.Entity.NewVehicle;
import project.cartracker.Entity.VehicleDetails;
import project.cartracker.Service.VehicleService;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class VehicleController {

    @Autowired
    VehicleService service;
    @RequestMapping(method = RequestMethod.POST , value = "/readings",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public NewVehicle postVehicle(@RequestBody NewVehicle newVehicle) {
        return service.postVehicle(newVehicle);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vehicles",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleDetails putVehicle(@RequestBody ArrayList<VehicleDetails> vehicleDetails) {
        return service.putVehicle(vehicleDetails);
    }
}

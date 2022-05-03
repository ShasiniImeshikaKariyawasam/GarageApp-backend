package com.thecodeveal.app.services;

import com.thecodeveal.app.config.VehicleDetailImpli;
import com.thecodeveal.app.entities.Vehicle;
import com.thecodeveal.app.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public VehicleDetailImpli loadVehicleByVehicleNum(String vehicleNum) throws VehicleNotFoundException {
        // TODO Auto-generated method stub

        Vehicle vehicle = vehicleRepository.findByVehicleNum(vehicleNum);
       // User user=userDetailsRepository.findByUserName(username);

        if(null==vehicle) {
            throw new VehicleNotFoundException("Vehicle Not Found with vehicle number "+ vehicleNum);
        }
        return this.build(vehicle);
    }

    public VehicleDetailImpli build(Vehicle vehicleInfo) {
        VehicleDetailImpli vehicle = new VehicleDetailImpli(
                vehicleInfo.getId(),
                vehicleInfo.getOwnerId(),
                vehicleInfo.getType(),
                vehicleInfo.getVehicleNum());
        return vehicle;
    }

    private class VehicleNotFoundException extends Throwable {
        public VehicleNotFoundException(String s) {
        }
    }
}

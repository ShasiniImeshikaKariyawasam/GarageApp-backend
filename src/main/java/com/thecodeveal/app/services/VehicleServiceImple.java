package com.thecodeveal.app.services;

import com.thecodeveal.app.entities.Vehicle;
import com.thecodeveal.app.repository.VehicleRepository;
import com.thecodeveal.app.repository.VehicleServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImple implements VehicleServiceRepo {

    private VehicleRepository vehicleRepository;

    public VehicleServiceImple(VehicleRepository vehicleRepository) {
        super();
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

//    @Override
//    public void updateById(Vehicle vehicle) {
//        vehicleRepository.updateById(vehicle);
//    }

    @Override
    public void deleteVehicleByVehicleNum(String vehicleNum) {

    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle getVehicleByOwnerId(String ownerId) {
        return vehicleRepository.findByVehicleNum(ownerId);
    }

    @Override
    public  Vehicle getVehicleByEmail(String email) { return vehicleRepository.findByVehicleNum(email); }

}

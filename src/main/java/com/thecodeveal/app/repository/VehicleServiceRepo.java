package com.thecodeveal.app.repository;

import com.thecodeveal.app.entities.Vehicle;

import java.util.List;

public interface VehicleServiceRepo {

    List<Vehicle> getAllVehicles();

    Vehicle saveVehicle(Vehicle vehicle);

    Vehicle getVehicleByOwnerId(String ownerId);

    Vehicle updateVehicle(Vehicle vehicle);

    void  deleteVehicleByVehicleNum(String vehicleNum);

    Vehicle getVehicleByEmail(String email);
}

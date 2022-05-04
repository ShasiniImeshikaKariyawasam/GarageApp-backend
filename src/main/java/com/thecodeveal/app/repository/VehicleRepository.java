package com.thecodeveal.app.repository;

import com.thecodeveal.app.entities.Vehicle;
import com.thecodeveal.app.responses.VehicleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByVehicleNum(String vehicleNum);
    Vehicle getVehicleById(Long id);

    Vehicle save(VehicleInfo vehicleInfo);
    Vehicle getVehicleByEmail(String email);

}
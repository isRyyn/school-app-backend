package com.app.school.service;
import com.app.school.model.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(Long id);

    Vehicle addVehicle(Vehicle vehicle);

    void deleteVehicle(Long id);
}

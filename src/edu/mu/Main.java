package edu.mu;

import edu.mu.vehiclemanager.VehicleManager;

public class Main {
	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements.
		VehicleManager vehicleManager = new VehicleManager();
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		vehicleManager.initializeStock();
		// Display all vehicle information.
		vehicleManager.displayAllTruckInformation();
		// Display all car information.
		vehicleManager.displayAllCarInformation();
		// Display all motorbike information.
		vehicleManager.displayAllMotorBikeInformation();
		//Calling method of getting highest and lowest vehicle fuel efficiency
		vehicleManager.getVehicleWithLowestFuelEfficiency(300.0, 3.25);
		vehicleManager.getVehicleWithHighestFuelEfficiency(300.0, 3.25);
	}
}

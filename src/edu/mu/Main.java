package edu.mu;

import edu.mu.vehiclemanager.VehicleManager;

public class Main {
	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements.
		VehicleManager vehicleManager = new VehicleManager();
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		vehicleManager.initializeStock();
		// Display all vehicle information.
		vehicleManager.displayAllVehicleInformation();
		// Display all car information.
		vehicleManager.displayAllCarInformation();
		// Display all motorbike information.
		vehicleManager.displayAllMotorBikeInformation();
	}
}

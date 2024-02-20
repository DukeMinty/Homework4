package edu.mu.vehicle.types;

import java.text.NumberFormat;

import edu.mu.vehicle.FuelType;
import edu.mu.vehicle.StartMechanism;
import edu.mu.vehicle.Vehicle;
import edu.mu.vehicle.VehicleColor;

public class Truck extends Vehicle{



	public Truck(String type, String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		setType("Truck");
		setStartType(StartMechanism.KEYSTART);
	}

	
	//copy
	public Truck(Truck original) {
		super(original);
	}
	
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	
	@Override
	public double calculateMaintenanceCost(double distance) {
		double maintenanceCost = distance*getMass()*(2024-getModelYear())*getCylinders()*0.0005;
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		
		return 0;
	}

	@Override
	public void startEngine() {
		// This needs to be Keystart
	}

}

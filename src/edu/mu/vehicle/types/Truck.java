package edu.mu.vehicle.types;

import edu.mu.vehicle.FuelType;
import edu.mu.vehicle.StartMechanism;
import edu.mu.vehicle.Vehicle;
import edu.mu.vehicle.VehicleColor;

public class Truck extends Vehicle{



	public Truck(String type, String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		setType(type);
	}

	
	//copy
	public Truck(Truck original) {
		super(original);
	}

	@Override
	public double calculateMaintenanceCost(double distance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		
	}

}

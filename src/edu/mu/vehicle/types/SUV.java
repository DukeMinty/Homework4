package edu.mu.vehicle.types;

import edu.mu.vehicle.FuelType;
import edu.mu.vehicle.StartMechanism;
import edu.mu.vehicle.Vehicle;
import edu.mu.vehicle.VehicleColor;

public class SUV extends Vehicle{

	public SUV(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		setStartType(StartMechanism.PUSHSTART);
	}

	@Override
	public double calculateMaintenanceCost(double distance) {
		double maintenanceCost = distance * getMass() * (2024-getModelYear()) * getCylinders() * 0.001;
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = getCylinders() * getGasTankCapacity() * fuelPrice / distance * 0.05;
		return fuelEfficiency;
	}

	@Override
	public void startEngine() {
		try {
			System.out.println("Pushing to start...");
            Thread.sleep(1000);
            System.out.println("VRRRRRRR");
            Thread.sleep(1000);;
            System.out.println("Started!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

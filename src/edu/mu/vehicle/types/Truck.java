package edu.mu.vehicle.types;

import edu.mu.vehicle.FuelType;
import edu.mu.vehicle.StartMechanism;
import edu.mu.vehicle.Vehicle;
import edu.mu.vehicle.VehicleColor;

public class Truck extends Vehicle{

	public Truck(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		//readFromFile should make sure these are Truck and Keystart
		//but this is an extra measure since they're mandatory traits
		setStartType(StartMechanism.KEYSTART);
	}

	
	//copy
	public Truck(Truck original) {
		super(original);
	}
	
	@Override
	public double calculateMaintenanceCost(double distance) {
		double maintenanceCost = distance*getMass()*(2024-getModelYear())*getCylinders()*0.002;
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = getCylinders()*getGasTankCapacity()*fuelPrice/distance*0.1;
		return fuelEfficiency;
	}

	@Override
	public void startEngine() {
		try {
			System.out.println("Turning key...");
            Thread.sleep(1000);
            System.out.println("Vr...");
            Thread.sleep(1000);
            System.out.println("VR..");
            Thread.sleep(1000);
            System.out.println("VRRRRRR");
            System.out.println("Started!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

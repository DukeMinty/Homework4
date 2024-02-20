package edu.mu.vehiclemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import edu.mu.vehicle.FuelType;
import edu.mu.vehicle.StartMechanism;
import edu.mu.vehicle.Vehicle;
import edu.mu.vehicle.VehicleColor;
import edu.mu.vehicle.types.Car;
import edu.mu.vehicle.types.MotorBike;
import edu.mu.vehicle.types.SUV;
import edu.mu.vehicle.types.Truck;

public class VehicleManager {
	
	private final static String vehicleFilePath = "files/vehicleList.csv";
	private ArrayList<Vehicle> vehicleList;
	
	public VehicleManager() {
		vehicleList = new ArrayList<Vehicle>();
	}
	
	public boolean initializeStock() {
		try (BufferedReader br = new BufferedReader(new FileReader(vehicleFilePath))) {
		    String line;
		    @SuppressWarnings("unused")
			String headerLine = br.readLine();
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        String type = values[0];
		        String brand = values[1];
		        String make = values[2];
		        long modelYear = Long.parseLong(values[3]);
		        double price = Double.parseDouble(values[4]);
		        VehicleColor color = VehicleColor.valueOf(values[5]);
		        FuelType fuelType = FuelType.valueOf(values[6]);
				double mileage = Double.parseDouble(values[7]);
				double mass = Double.parseDouble(values[8]);
				int cylinders = Integer.parseInt(values[9]);
				double gasTankCapacity = Double.parseDouble(values[10]);
				StartMechanism startType = StartMechanism.valueOf(values[11]);
	            if("Truck".equals(type)) {
	            	Vehicle vehicle = new Truck(type,brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
	            	vehicleList.add(vehicle);
	            }
	            else if("SUV".equals(type)) {
	            	Vehicle vehicle = new SUV(type,brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
	            	vehicleList.add(vehicle);
	            }
	            else if("Car".equals(type)) {
	            	Vehicle vehicle = new Car(type,brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
	            	vehicleList.add(vehicle);
	            }
	            else if("MotorBike".equals(type)) {
	            	Vehicle vehicle = new MotorBike(type,brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
	            	vehicleList.add(vehicle);
	            }
	            else {
	            	System.out.println("Error");
	            }
		    }
		    br.close();
		    return true;
		}catch (IOException e) {
			System.out.println("Error occured");
	        e.printStackTrace();
	        return false;
	    }
		catch(IllegalArgumentException e) {
			System.out.println("Data is incompatible");
			e.printStackTrace();
			return false;
		}
	}
	
	public void displayInformation(Vehicle vehicle) {
		if(vehicle == null) {
			System.out.println("VEHICLE COULD NOT BE INITIALIZED");
		}
		System.out.println(vehicle.toString());
		//Ask prof how to get the fuelPrice and distance in order to print off these statistics
		System.out.println("Fuel Efficiency:");
		//TODO NOT FINISHED
		System.out.println(vehicle.calculateFuelEfficiency(0, 0));
		System.out.println("Maintenance Cost:");
		//TODO NOT FINISHED
		System.out.println(vehicle.calculateMaintenanceCost(0));
		System.out.println("Starting Vehicle!");
		vehicle.startEngine();
	}

	public void displayAllCarInformation() {
		for(Vehicle vehicle : vehicleList) {
			if(vehicle instanceof Car) {
				displayInformation(vehicle);
			}
		}
	}
	
	public void displayAllTruckInformation() {
		for(Vehicle vehicle : vehicleList) {
			if(vehicle instanceof Truck) {
				displayInformation(vehicle);
			}
		}
	}
	public void displayAllSUVInformation() {
		for(Vehicle vehicle : vehicleList) {
			if(vehicle instanceof SUV) {
				displayInformation(vehicle);
			}
		}
	}
	public void displayAllMotorBikeInformation() {
		for(Vehicle vehicle : vehicleList) {
			if(vehicle instanceof MotorBike) {
				displayInformation(vehicle);
			}
		}
	}
	public void displayAllVehicleInformation() {
		for(Vehicle vehicle : vehicleList) {
			displayInformation(vehicle);
		}
	}
}

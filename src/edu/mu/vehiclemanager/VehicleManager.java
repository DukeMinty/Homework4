package edu.mu.vehiclemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
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
	
	
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;
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
	            	Vehicle vehicle = new Truck(brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
	            	vehicleList.add(vehicle);
	            }
	            else if("SUV".equals(type)) {
	            	Vehicle vehicle = new SUV(brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
	            	vehicleList.add(vehicle);
	            }
	            else if("Car".equals(type)) {
	            	Vehicle vehicle = new Car(brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
	            	vehicleList.add(vehicle);
	            }
	            else if("MotorBike".equals(type)) {
	            	Vehicle vehicle = new MotorBike(brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
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
	
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	
	public void displayInformation(Vehicle vehicle) {
		if(vehicle == null) {
			System.out.println("VEHICLE COULD NOT BE INITIALIZED");
		}
		System.out.println(vehicle.toString());
		System.out.println("Fuel Efficiency:");
		System.out.println(vehicle.calculateFuelEfficiency(distance, fuelPrice));
		System.out.println("Maintenance Cost:");
		System.out.println(currencyFormat.format(vehicle.calculateMaintenanceCost(distance)));
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
	
	public boolean removeVehicle(Vehicle vehicle) {
		// Removes the specified vehicle from the vehicleList
		if (vehicle == null) {
			return false;
		}
		
		boolean vehicleExists = false;
		
		for (Vehicle v : vehicleList) {
			if (vehicle.equals(v)) {
				vehicleExists = true;
				vehicleList.remove(vehicle);
				break;
			}
		}
		
		return vehicleExists;
	}
	
	public boolean addVehicle(Vehicle vehicle) {
		if (vehicle == null) {
			return false;
		}
		
		boolean vehicleExists = false;
		
		for (Vehicle v : vehicleList) {
			if (vehicle.equals(v)) {
				vehicleExists = true;
				break;
			}
		}
		
		if (vehicleExists) {
			return false;
		}
		
		vehicleList.add(vehicle);
		return true;
	}

	public boolean saveVehicleList(){
//		o Saves the updated vehicleList back to the CSV file located at vehicleFilePath.
//		o Overwrites the existing file with the updated data.
//		o Returns true if the saving is successful, false otherwise (file does not exist, or file empty).
	}

	private boolean isVehicleType(Vehicle v, Class clazz) {
//		o Checks if the given vehicle is a specific type of Vehicle subclass.
//		o If the given vehicle object is the object type, then return true, otherwise return false.
//		o Use instanceof or getClass() to count the number.
//		o Call example: isVehicleType(vehicleObj, Truck.class);
	}

	public int getNumberOfVehichlesByType(Class clazz) {
//		o Returns the number of objects in the vehicle list based on the object vehicle type
//		o Use the isVehicleType(Vehicle v, Class clazz) method.
//		o Call example: getNumberOfVehichlesByType(SUV.class);
	}

	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
//		o Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle
//		with the highest maintenance cost.
//		o If multiple vehicles have the same maintenance cost, randomly return one of the
//		vehicles (Use the Random class for random selection).
	}

	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
//		o Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle
//		with the lowest maintenance cost.
//		o If multiple vehicles have the same maintenance cost, randomly return one of the
//		vehicles (Use the Random class for random selection).
	}

	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice){
//		o Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle
//		with the highest fuel efficiency.
//		o If multiple vehicles have the same highest fuel efficiency, return vehicles with the same
//		highest fuel efficiency in an ArrayList.
	}

	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice){
//		o Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle
//		with the lowest fuel efficiency.
//		o If multiple vehicles have the same lowest fuel efficiency, return vehicles with the same
//		lowest fuel efficiency in an ArrayList.
	}

	public double getAverageFuelEfficiencyOfSUVs(double distance,double fuelPrice) {
//		o Calculate the average/mean of the fuel efficiency of SUVs in the vehicle list.
//		o Use the isVehicleType(Vehicle v, Class clazz) method.
//		o If no SUVs exist in the list return -1.0 as an error code that indicates there is no SUVs in
//		the list to calculate the average fuel efficiency
	}
}

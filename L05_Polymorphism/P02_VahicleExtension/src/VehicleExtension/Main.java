package VehicleExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Create car
        String[] tokens = scanner.nextLine().split("\\s+");
        Vehicle car = createVehicle(tokens);

        //Create truck
        tokens = scanner.nextLine().split("\\s+");
        Vehicle truck = createVehicle(tokens);

        //Create bus
        tokens = scanner.nextLine().split("\\s+");
        Vehicle bus = createVehicle(tokens);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus", bus);

        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= countCommands ; count++) {

            //o	Drive Car {distance}
            //o	Drive Truck {distance}
            //o	Refuel Car {liters}
            //o	Refuel Truck {liters}
            //o DriveEmpty Bus 100
            tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehicleType = tokens[1];

            switch (commandName){
                case "Drive" -> {
                    double distance = Double.parseDouble(tokens[2]);
                    Vehicle currentVehicle = vehicleMap.get(vehicleType);
                    String driveMessage = currentVehicle.drive(distance);
                    System.out.println(driveMessage);
                }
                case "Refuel" -> {
                    double fuelAmount = Double.parseDouble(tokens[2]);
                    vehicleMap.get(vehicleType).refuel(fuelAmount);
                }
                case "DriveEmpty" -> {
                    double distance = Double.parseDouble(tokens[2]);
                    System.out.println(bus.driveEmpty(distance));
                }
            }

        }

        vehicleMap.values().forEach(System.out::println);


    }

    private static Vehicle createVehicle(String[] tokens) {

        //Car {fuel quantity} {liters per km}
        //Truck {fuel quantity} {liters per km}
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);

        Vehicle vehicle = null;
        switch (vehicleType){
            case "Car" -> vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck" -> vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "Bus" -> vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }

        return vehicle;
    }
}
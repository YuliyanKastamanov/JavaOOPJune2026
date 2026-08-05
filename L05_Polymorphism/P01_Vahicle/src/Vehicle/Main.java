package Vehicle;

import java.util.HashMap;
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

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);

        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= countCommands ; count++) {

            //o	Drive Car {distance}
            //o	Drive Truck {distance}
            //o	Refuel Car {liters}
            //o	Refuel Truck {liters}
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

        Vehicle vehicle = null;
        switch (vehicleType){
            case "Car" -> vehicle = new Car(fuelQuantity, fuelConsumption);
            case "Truck" -> vehicle = new Truck(fuelQuantity, fuelConsumption);
        }

        return vehicle;
    }
}
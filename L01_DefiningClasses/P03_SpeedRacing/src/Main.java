import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String carModel = data[0];
            double fuel = Double.parseDouble(data[1]);
            double costPerKm = Double.parseDouble(data[2]);
            int distance = 0;

            Car currentCar = new Car(carModel, fuel, costPerKm, distance);

            cars.put(carModel, currentCar);

        }

        String command = scanner.nextLine();



        while (!command.equals("End")){
            String[] commandData = command.split("\\s+");

            String currentCar = commandData[1];
            int distance = Integer.parseInt(commandData[2]);


            boolean isMoving = cars.get(currentCar).isMoving(distance);


            if(isMoving){
                double restFuel = cars.get(currentCar).restFuel(distance);
                cars.get(currentCar).setFuelAmount(restFuel);
                int currentDistance = cars.get(currentCar).getDistanceTraveled();
                cars.get(currentCar).setDistanceTraveled(currentDistance + distance);

            }else {
                System.out.println("Insufficient fuel for the drive");
            }


            command = scanner.nextLine();



        }

        cars.entrySet().stream().forEach(entry -> System.out.println(entry.getValue()));

    }


}
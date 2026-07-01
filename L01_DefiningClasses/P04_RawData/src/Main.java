package L06_DefiningClasses.Exercises.P04_RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String , List<Car>> cargoTypes = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] rawData = scanner.nextLine().split("\\s+");


            String model = rawData[0];
            int engineSpeed = Integer.parseInt(rawData[1]);
            int enginePower = Integer.parseInt(rawData[2]);
            int cargoWeight = Integer.parseInt(rawData[3]);
            String cargoType = rawData[4];
            double tirePress1 = Double.parseDouble(rawData[5]);
            int tyreAge1 = Integer.parseInt(rawData[6]);
            double tirePress2 = Double.parseDouble(rawData[7]);
            int tyreAge2 = Integer.parseInt(rawData[8]);
            double tirePress3 = Double.parseDouble(rawData[9]);
            int tyreAge3 = Integer.parseInt(rawData[10]);
            double tirePress4 = Double.parseDouble(rawData[11]);
            int tyreAge4= Integer.parseInt(rawData[12]);

            Tire tire1 = new Tire(tyreAge1, tirePress1);
            Tire tire2 = new Tire(tyreAge2, tirePress2);
            Tire tire3 = new Tire(tyreAge3, tirePress3);
            Tire tire4 = new Tire(tyreAge4, tirePress4);
            List<Tire> currentTires = new ArrayList<>();
            currentTires.add(tire1);
            currentTires.add(tire2);
            currentTires.add(tire3);
            currentTires.add(tire4);

            Cargo currentCargo = new Cargo(cargoWeight, cargoType);
            Engine currentEngine = new Engine(engineSpeed, enginePower);

            Car currentCar = new Car(model, currentEngine, currentCargo, currentTires);
            List<Car> car = new ArrayList<>();
            boolean isCorrect = isInRange(tirePress1, tirePress2, tirePress3, tirePress4, enginePower, cargoType);

            if(isCorrect) {
                if (!cargoTypes.containsKey(cargoType)) {

                    car.add(currentCar);
                    cargoTypes.put(cargoType, car);
                } else {
                    car = cargoTypes.get(cargoType);
                    car.add(currentCar);
                    cargoTypes.put(cargoType, car);

                }
            }
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")){
            cargoTypes.remove("flamable");

        }else if (command.equals("flamable")){
            cargoTypes.remove("fragile");

        }

        cargoTypes.entrySet().forEach(entry -> entry.getValue().forEach(e -> System.out.println(e.getCarModel())));


    }

    private static boolean isInRange(double tirePress1, double tirePress2, double tirePress3, double tirePress4, int enginePower, String cargoType) {

        if (cargoType.equals("fragile")){
            if (tirePress1 < 1 || tirePress2 < 1 || tirePress3 < 1 || tirePress4 < 1){
                return true;
            }
        }else if (cargoType.equals("flamable")){
            if (enginePower > 250){
                return true;
            }
        }

        return false;
    }
}

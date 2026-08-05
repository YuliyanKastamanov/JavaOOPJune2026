package VehicleExtension;

import java.text.DecimalFormat;

public class Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;


    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public void refuel(double liters){
        //Проверяваме дали литрите са отрицателно число
        if(liters <= 0){
            System.out.println("Fuel must be a positive number");
            return;
        }else if(this.getFuelQuantity() + liters > this.getTankCapacity()) {// има ли място в резервоара, за да дозаредя
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.fuelQuantity += liters;
    }

    public String driveEmpty(double distance){

        return null;
    }

    public String drive(double distance){
        //Car or Truck
        double neededFuel = distance * this.getFuelConsumption();

        //проверяваме дали имаме достатъчно гориво
        if(neededFuel > this.getFuelQuantity()){
            //не мога да измина дистанцията
            //връщаме String, че трябва да презаредим
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        //изминаваме дистанцията -> намаляме горивото в резервоара
        this.fuelQuantity = this.getFuelQuantity() - neededFuel;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
    }


    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}

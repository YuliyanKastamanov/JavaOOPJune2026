package Vehicle;

import java.text.DecimalFormat;

public class Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;


    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public void refuel(double liters){
        this.fuelQuantity += liters;
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

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}

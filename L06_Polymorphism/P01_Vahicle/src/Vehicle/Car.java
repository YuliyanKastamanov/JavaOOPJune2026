package Vehicle;

public class Car extends Vehicle{

    private final static double ADDITIONAL_AC_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption = this.getFuelConsumption() + ADDITIONAL_AC_CONSUMPTION;
    }
}

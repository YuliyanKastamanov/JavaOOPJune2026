package Vehicle;

public class Truck extends Vehicle{

    private final static double ADDITIONAL_AC_CONSUMPTION = 1.6;
    private final static double FUEL_LEAK_CORRECTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption = this.getFuelConsumption() + ADDITIONAL_AC_CONSUMPTION;
    }

    @Override
    public void refuel(double liters) {
        liters = liters * FUEL_LEAK_CORRECTION;
        //this.fuelQuantity += liters;
        super.refuel(liters);
    }
}

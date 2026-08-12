package VehicleExtension;

public class Bus extends Vehicle{

    private double emptyBusFuelConsumption;
    private double nonEmptyBusFuelConsumption;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.emptyBusFuelConsumption = fuelConsumption;
        this.nonEmptyBusFuelConsumption = fuelConsumption + 1.4;
    }

    //Движим се с пълен Автобус
    @Override
    public String drive(double distance) {

        this.setFuelConsumption(nonEmptyBusFuelConsumption);
        return super.drive(distance);

    }

    //Движа се с автобус без хора! Празен Автобус

    public String driveEmpty(double distance){

        this.setFuelConsumption(emptyBusFuelConsumption);
        return super.drive(distance);
    }
}

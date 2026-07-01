public class Car {
    private  String model;
    private double fuelAmount;
    private double fuelConsumptionPerKm;
    private int distanceTraveled;


    public Car(String model, double fuelAmount, double fuelConsumptionPerKm, int distanceTraveled) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public boolean isMoving(int distance) {

        double maxPossibleKilometers = fuelConsumptionPerKm * distance;

        if (maxPossibleKilometers <= fuelAmount){
            return true;
        }
        return false;
    }

    public double restFuel(int distance) {

        double restFuel = fuelAmount - (distance * fuelConsumptionPerKm);

        return restFuel;
    }

    @Override

    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(model + " ").append(String.format("%.2f ", fuelAmount)).append(String.format("%d", distanceTraveled));

        return builder.toString();
    }
}
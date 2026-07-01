package L06_DefiningClasses.Exercises.P04_RawData;
public class Tire {

    private int tireAge;
    private double tirePressure;

    public Tire(int tireAge, double tirePressure) {
        this.tireAge = tireAge;
        this.tirePressure = tirePressure;
    }

    public double getTirePressure() {
        return tirePressure;
    }
}

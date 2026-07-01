package L06_DefiningClasses.Exercises.P04_RawData;

import java.util.List;

public class Car {
    private String carModel;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String carModel, Engine engine, Cargo cargo, List<Tire> tires) {
        this.carModel = carModel;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getCarModel() {
        return carModel;
    }

    public List<Tire> getTires() {
        return tires;
    }
}

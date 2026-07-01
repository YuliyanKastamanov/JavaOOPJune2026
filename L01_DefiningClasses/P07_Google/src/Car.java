public class Car {

    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public Car() {
        this.model = "";
        this.speed = -1;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        //Trabant 30
        return  this.model.equals("")
                ? "Car:"
                : String.format("Car:%n%s %d", this.model, this.speed);
    }
}

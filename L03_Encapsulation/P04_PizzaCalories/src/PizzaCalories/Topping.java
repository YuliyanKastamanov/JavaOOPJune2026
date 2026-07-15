package PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;


    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {

        //•	Meat – 1.2;
        //•	Veggies – 0.8;
        //•	Cheese – 1.1;
        //•	Sauce – 0.9;
        switch (toppingType){
            case "Meat", "Veggies", "Cheese", "Sauce" -> this.toppingType = toppingType;
            default -> throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

    }

    private void setWeight(double weight) {
        if(weight >= 1 && weight <= 50){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
    }

    public double calculateCalories(){

        //For example, meat has a modifier of 1.2,
        // which means that meat weighing 50 grams will have (2 * 50) * 1.2 = 120.00 total calories.

        //•	Meat – 1.2;
        //•	Veggies – 0.8;
        //•	Cheese – 1.1;
        //•	Sauce – 0.9;

        double toppingCoefficient = 0;

        switch (this.toppingType){
            case "Meat" -> toppingCoefficient = 1.2;
            case "Veggies" -> toppingCoefficient = 0.8;
            case "Cheese" -> toppingCoefficient = 1.1;
            case  "Sauce" -> toppingCoefficient = 0.9;
        }

        return 2 * this.weight * toppingCoefficient;
    }
}

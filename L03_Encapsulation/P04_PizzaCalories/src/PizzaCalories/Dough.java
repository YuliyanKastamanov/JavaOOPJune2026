package PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        switch (flourType){
            case "White", "Wholegrain" -> this.flourType = flourType;
            default -> throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique){
            case "Crispy", "Chewy", "Homemade" -> this.bakingTechnique = bakingTechnique;
            default -> throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setWeight(double weight) {
        if(weight >= 1 && weight <= 200){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories(){

        double flourTypeCoefficient = 0;
        switch (this.flourType){
            case "White" -> flourTypeCoefficient = 1.5;
            case "Wholegrain" -> flourTypeCoefficient = 1.0;

        }

        double bakingTechniquesCoefficient = 0;
        switch (this.bakingTechnique){
            case "Crispy" -> bakingTechniquesCoefficient = 0.9;
            case "Chewy" -> bakingTechniquesCoefficient = 1.1;
            case "Homemade" -> bakingTechniquesCoefficient = 1.0;
        }

        //For example, the white dough has a modifier of 1.5, a chewy dough has a modifier of 1.1,
        // which means that a white chewy dough weighing 100 grams will have (2 * 100) * 1.5 * 1.1 = 330.00 total calories.

        return 2 * this.weight * flourTypeCoefficient * bakingTechniquesCoefficient;

    }
}

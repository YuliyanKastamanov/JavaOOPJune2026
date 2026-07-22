package Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {

        if(!name.isBlank()){

            this.name = name;
        }else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if(age >= 0){

            this.age = age;
        }else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        if(!gender.isBlank()){
            this.gender = gender;
        }else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }


    public String produceSound(){
        return null;
    }

    @Override
    public String toString() {

        //•	Print the information for each animal in three lines. On the first line, print: "{animalType}".
        //•	On the second line, print: "{name} {age} {gender}".
        //•	On the third line, print the sounds it produces: "{produceSound()}".

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%n", this.getClass().getSimpleName()));
        builder.append(String.format("%s %d %s%n", this.name, this.age, this.gender));
        builder.append(this.produceSound());

        return builder.toString();
    }
}

public class Person {


    private String name;
    private int age;
    private double salary;




    public Person(String name, int age, double salary) {
        this.name = name;
        setAge(age);
        this.salary = salary;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if(age >= 0){
            this.age = age;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean checkSalary(double salary){

        if(this.salary > salary){
            this.salary -= salary;
            return true;
        }

        return false;

    }
}

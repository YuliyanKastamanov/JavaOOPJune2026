public class Employee {

    private String name;
    private double salary;

    public void present(){
        System.out.printf("My name is: %s, my salary is: %.2f.", name, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

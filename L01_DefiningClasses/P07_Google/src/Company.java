public class Company {

    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Company() {
        this.name = "";
        this.department = "";
        this.salary = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {

        //Company:
        //{companyName} {companyDepartment} {salary}

       /* StringBuilder builder = new StringBuilder();

        if(this.name.equals("")){
            builder.append("Company:");
        }else {
            builder.append(String.format("Company:%n%s %s %.2f", name, department, salary));
        }
        return builder.toString();*/

        return this.name.equals("")
                ? "Company:"
                : String.format("Company:%n%s %s %.2f", name, department, salary);


    }
}

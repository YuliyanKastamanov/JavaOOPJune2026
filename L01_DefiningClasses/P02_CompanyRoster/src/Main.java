import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int countEmployees = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> employeesMap = new HashMap<>();

        for (int i = 1; i <= countEmployees ; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            //name, salary, position, department, email, and age
            //The name, salary, position, and department are mandatory
            //"Peter 120.00 Dev Development peter@abv.bg 28"

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            //Създашаме празен обект
            Employee currentEmployee = null;

            if(data.length == 4){
                //1 - имаме само 4 задължителни полета
                currentEmployee = new Employee(name, salary, position, department);
            } else if (data.length == 6) {
                //имаме всички полета
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                currentEmployee = new Employee(name, salary, position, department, email, age);

            }else if(data.length == 5){
                String element5 = data[4];//може да бъде или мейл или години

                if(element5.contains("@")){
                    String email = element5;
                    currentEmployee = new Employee(name, salary, position, department, email);
                }else {
                    int age = Integer.parseInt(data[4]);
                    currentEmployee = new Employee(name, salary, position, department, age);
                }
            }

            //добавяме служителя в мап-а

            if(!employeesMap.containsKey(department)){
                //нямаме създаден такъв департмънт
                List<Employee> currentEmployeeList = new ArrayList<>();
                currentEmployeeList.add(currentEmployee);
                employeesMap.put(department, currentEmployeeList);
            }else {
                //добавяме служителя към вече съществуващ департмънт
                employeesMap.get(department).add(currentEmployee);
            }

        }

        //намираме департмънт с най-висока заплата
        String maxAverageSalaryDep = employeesMap.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()//entry -> (отдел -> списък със служители) -> резултата от max() метода -> отделът с най-висока заплата
                .getKey();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDep);

        //намираме служителите от отдела с най-висока средна заплата
        List<Employee> employeesWithMaxAverageSalary = employeesMap.get(maxAverageSalaryDep);

        //сортираме служителите спрямо заплатата в низходяш ред -> от най-висока към най-ниска заплата
        employeesWithMaxAverageSalary.sort(Comparator.comparing(Employee::getSalary));// метода sort() Подрежда от най-ниско към най-високо

        //обръщаме реда на подредба ->  най-висока към най-ниска заплата
        Collections.reverse(employeesWithMaxAverageSalary);

        for (Employee employee : employeesWithMaxAverageSalary){
            System.out.println(employee);
        }






    }

    private static double getAverageSalary(List<Employee> employeeList) {

        double sum = 0;
        for (Employee employee : employeeList){
            sum += employee.getSalary();
        }

        return sum / employeeList.size();
    }
}
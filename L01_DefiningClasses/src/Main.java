import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 1; i <= countPeople ; i++) {

            //"Peter 12"
            String[] data = scanner.nextLine().split("\\s+");//["Peter", "12"]
            String name = data[0];//"Peter"
            int age = Integer.parseInt(data[1]);//12

            if(age > 30){
                Person currentPerson = new Person(name, age);
                people.add(currentPerson);
            }

        }


        people.sort(Comparator.comparing(Person::getName));
        people.forEach(person -> System.out.println(person.toString()));

    }
}
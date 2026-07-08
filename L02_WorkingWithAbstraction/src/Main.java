import javax.management.relation.Role;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Suit role = Suit.ADMIN;

        Person newPerson = new Person("Stoyan", 19, 5000);

        System.out.println(newPerson);








    }
}
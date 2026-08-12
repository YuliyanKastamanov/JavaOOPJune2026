import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_EnterNumbers {
    public static void main(String[] args) {



        List<Integer> numbers = readNumbers(1, 100);

        String numberSeparatedByComma = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(numberSeparatedByComma);


    }

    private static List<Integer> readNumbers(int start, int end) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 10){

            try{
                int number = Integer.parseInt(scanner.nextLine());
                if(number <= start || number >= end){
                    System.out.printf("Your number is not in range %d - 100!%n", start);
                }else {
                    numbers.add(number);
                    start = number;
                }

            }catch (Exception exception){
                System.out.println("Invalid Number!");
            }
        }

        return numbers;

    }
}

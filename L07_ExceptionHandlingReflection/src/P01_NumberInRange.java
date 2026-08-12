import java.util.Arrays;
import java.util.Scanner;

public class P01_NumberInRange {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startRange = range[0];
        int endRange = range[1];

        System.out.printf("Range: [%d...%d]%n", startRange, endRange);


        boolean isValidNumber = false;
        int validNumber = 0;



        while (!isValidNumber){
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                validNumber = number;
                isValidNumber = validateNumber(number, startRange, endRange);

            }catch (NumberFormatException | IndexOutOfBoundsException exception){

                System.out.println("Invalid number: " + input);
            }

        }


        System.out.println("Valid number: " + validNumber);


    }

    private static boolean validateNumber(int number, int startRange, int endRange) {
        // number = 5, startRange = 10, endRange = 20;
        boolean isValid = number >= startRange && number <= endRange;

        //ако горното не е вярно isValid = false
        if (!isValid) {
            throw new IndexOutOfBoundsException();
        }
        return true;

    }
}

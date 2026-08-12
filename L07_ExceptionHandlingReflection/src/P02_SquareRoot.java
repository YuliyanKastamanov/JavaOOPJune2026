import java.util.Scanner;

public class P02_SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        //Вариант 1
       /* try {
            int number = Integer.parseInt(input);
            if(number < 0){
                System.out.println("Invalid");
            }else {
                double squareRoot = Math.sqrt(number);
                System.out.printf("%.2f%n", squareRoot);
            }
        }catch (Exception exception){
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }*/

        //Вариант 2
        try {
            int number = Integer.parseInt(input);
            checkNumber(number);
            double squareRoot = Math.sqrt(number);
            System.out.printf("%.2f%n", squareRoot);
        }catch (Exception exception){
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }
    }

    private static void checkNumber(int number) throws Exception {
        if(number < 0){
            throw new Exception();
        }
    }


}

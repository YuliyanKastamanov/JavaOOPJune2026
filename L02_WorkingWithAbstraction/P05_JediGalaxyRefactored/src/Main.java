import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readPositions(scanner.nextLine());

        Galaxy galaxy = new Galaxy(new Field(dimensions[0],dimensions[1] ));

        String command = scanner.nextLine();
        long starPowerCollection = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = readPositions(command);
            int[] evilPosition = readPositions(scanner.nextLine());

            int jediRow = jediPosition[0];
            int jediCol = jediPosition[1];
            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            galaxy.moveEvil(evilRow, evilCol);
            starPowerCollection += galaxy.moveJedi(jediRow, jediCol);

            command = scanner.nextLine();
        }

        System.out.println(starPowerCollection);

    }

    private static int[] readPositions(String scanner) {
        return Arrays.stream(scanner.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
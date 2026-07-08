import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Lights[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(light -> Lights.valueOf(light))
                .toArray(Lights[]::new);

        int countOfColorUpdates = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countOfColorUpdates ; i++) {

            //updateLight -> променяме светлината на светофара
            updateLights(lights);
            //printLight -> принтираме светлинната сигнализация на светофара
            printLights(lights);


        }






    }

    private static void printLights(Lights[] lights) {

        for (Lights light : lights){
            System.out.print(light + " ");
        }
        System.out.println();
    }

    private static void updateLights(Lights[] lights) {

        //red -> green -> yellow -> red
        //Lights light -> копие на реалната стойност от нашата структура от данни
        // ако се опитаме да променим това копие, то Няма да промени самата стойност в структурата от данни
        /*for (Lights light : lights){
            switch (light){
                case RED -> light = Lights.GREEN;
                case GREEN -> light = Lights.YELLOW;
                case YELLOW -> light = Lights.RED;
            }
            System.out.println(light);
        }*/

        for (int index = 0; index < lights.length; index++) {

            switch (lights[index]){
                case RED -> lights[index] = Lights.GREEN;
                case GREEN -> lights[index] = Lights.YELLOW;
                case YELLOW -> lights[index] = Lights.RED;
            }

        }


    }
}
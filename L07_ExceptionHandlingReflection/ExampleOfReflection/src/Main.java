import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Constructor<BlackBox> costructor = BlackBox.class.getDeclaredConstructor();

        costructor.setAccessible(true);

        BlackBox blackBox = costructor.newInstance();

        Method[] declaredMethods = blackBox.getClass().getDeclaredMethods();
        //Method[] methods = blackBox.getClass().getMethods();

        Field[] fields = blackBox.getClass().getDeclaredFields();// получаваме достъп до всички декларирани полета
        Field innerValue =  blackBox.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        while (!input.equals("End")){

            //add_{number}
            //divide_{number}

            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            Method currentMethod = Arrays.stream(declaredMethods)
                    .filter(method -> method.getName().equals(command))
                    .findFirst()
                    .orElse(null);

            currentMethod.setAccessible(true);

            currentMethod.invoke(blackBox, value);
            System.out.println(innerValue.get(blackBox));

            input = scanner.nextLine();

        }





    }
}
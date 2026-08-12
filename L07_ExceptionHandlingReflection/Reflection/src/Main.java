import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


        Class<Reflection> reflectionClass = Reflection.class;

        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());
        Class[] interfaces = reflectionClass.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Reflection reflection = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(reflection);

    }
}
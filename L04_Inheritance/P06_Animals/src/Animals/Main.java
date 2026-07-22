package Animals;
public class Main {
    public static void main(String[] args) {


        Animal animal = new Animal("Tom", 1, "male");

        Kitten kitten = new Kitten("Kitty", 2, "Male");

        Tomcat tomcat = new Tomcat("Tom", 10, "Female");

        Dog dog = new Dog("Sharo", 5, "Male");

        Frog frog = new Frog("Kermit", 12, "Male");

        Cat cat = new Cat("Betty", 4, "Female");

        System.out.println(animal);
        System.out.println(kitten);
        System.out.println(tomcat);
        System.out.println(dog);
        System.out.println(frog);
        System.out.println(cat);



    }
}
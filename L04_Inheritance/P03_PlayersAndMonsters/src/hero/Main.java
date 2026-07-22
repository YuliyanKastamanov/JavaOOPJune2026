package hero;

public class Main {
    public static void main(String[] args) {


        BladeKnight hero = new BladeKnight("New Hero", 25);

        System.out.println(hero.getUsername());
        System.out.println(hero.getLevel());
        System.out.println(hero);

    }
}
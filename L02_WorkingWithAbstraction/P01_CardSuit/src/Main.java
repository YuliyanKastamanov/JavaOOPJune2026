import java.util.List;

public class Main {
    public static void main(String[] args) {


        System.out.println("Card Suits:");

        //List<Suits> suits = List.of(Suits.values());
        Suits[] suits = Suits.values();

        for (Suits suit : suits){

            //suit.ordinal() - поредността в енумерацията
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }






    }
}
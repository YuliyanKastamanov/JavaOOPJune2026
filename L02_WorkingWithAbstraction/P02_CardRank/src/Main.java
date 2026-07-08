import com.sun.jdi.Value;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");

        List<CardRank> cardRanks = List.of(CardRank.values());

        cardRanks.forEach(cardRank -> System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank.name()));

    }
}
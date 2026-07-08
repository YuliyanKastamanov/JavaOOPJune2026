import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();


        int cardPower = RankPower.valueOf(cardRank).getPower() + SuitsPower.valueOf(cardSuit).getPower();
        System.out.printf("Card name: %s of %s; Card power: %d", cardRank, cardSuit, cardPower);









    }
}
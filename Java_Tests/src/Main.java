import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double change = Double.parseDouble(console.nextLine());

        int twoLevaCoins = 0;
        int oneLevaCoins = 0;
        int totalCoins = 0;

        int leva = (int) change;

        twoLevaCoins = (int) (leva / 2);

        if (leva % 2 != 0) {
            oneLevaCoins = 1;
        }

        int coins = (int) ((change - leva) * 100);

        int coins50 = coins / 50;
        int coins20 = (coins - coins50 * 50) / 20;
        int coins10 = (coins - coins50 * 50 - coins20 * 20) / 10;
        int coins5 = (coins - coins50 * 50 - coins20 * 20 - coins10 * 10) / 5;
        int coins2 = (coins - coins50 * 50 - coins20 * 20 - coins10 * 10 - coins5 * 5) / 2;
        int coins1 = (coins - coins50 * 50 - coins20 * 20 - coins10 * 10 - coins5 * 5 - coins2 * 2);

        //System.out.printf("%d,%d,%d,%d,%d,%d,%d,%d%n", twoLevaCoins, oneLevaCoins, coins50, coins20, coins10, coins5, coins2, coins1);

        totalCoins = coins1 + coins2 + coins5 + coins10 + coins20 + coins50 + oneLevaCoins + twoLevaCoins;
        System.out.printf("%d", totalCoins);
    }
}

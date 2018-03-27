import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double juicePerCherry = 15.0;
        double juicePerStrawberry = 7.5;
        double juicePerRaspbrry = 4.5;

        int raspberriesCount = Integer.parseInt(reader.readLine());
        int strawberriesCount = Integer.parseInt(reader.readLine());
        int cherriesCount = Integer.parseInt(reader.readLine());
        int maxJuice = Integer.parseInt(reader.readLine());


        int usedCherries = 0;
        int usedStrawberries = 0;
        int usedRaspberries = 0;
        double ourJuice = 0;

        for (int i = 1; i <= cherriesCount; i++) {
            if (ourJuice > Double.parseDouble(Integer.toString(maxJuice))) {
                break;
            } else {
                usedCherries++;
                ourJuice += 15;
            }
        }

        for (int i = 1; i <= strawberriesCount; i++) {
            if (ourJuice > Double.parseDouble(Integer.toString(maxJuice))) {
                break;
            } else {
                usedStrawberries++;
                ourJuice += 7.5;
            }
        }

        for (int i = 1; i <= raspberriesCount; i++) {
            if (ourJuice > Double.parseDouble(Integer.toString(maxJuice))) {
                break;
            } else {
                usedStrawberries++;
                ourJuice += 4.5;
            }
        }

        System.out.printf(
                "%d Raspberries, %d Strawberries, %d Cherries. Juice: %.0f ml.",
                usedRaspberries, usedStrawberries, usedCherries, Math.floor(ourJuice));

        /*Scanner console = new Scanner(System.in);
        int raspberries = Integer.parseInt(console.nextLine());
        int strawberries = Integer.parseInt(console.nextLine());
        int cherries = Integer.parseInt(console.nextLine());
        int totalJuice = Integer.parseInt(console.nextLine());

        double cherryJuice = 15;
        double strawberryJuice = 7.5;
        double raspberryJuice = 4.5;
        double maxJuice = -1;

        for (int cherriesNum = 0; cherriesNum <= cherries; cherriesNum++) {
            for (int raspberriesNum = 0; raspberriesNum <= raspberries; raspberriesNum++) {
                for (int strawberriesNum = 0; strawberriesNum <= strawberries; strawberriesNum++) {

                    double juice = (cherriesNum * cherryJuice) + (strawberriesNum * strawberryJuice) + (raspberriesNum * raspberryJuice);

                    if (juice <= totalJuice) {
                        maxJuice = Math.max(juice, maxJuice);
                    }
                }
            }
        }

        for (int cherriesNum = cherries; cherriesNum >= 0; cherriesNum--) {
            for (int strawberriesNum = strawberries; strawberriesNum >= 0; strawberriesNum--) {
                for (int raspberriesNum = raspberries; raspberriesNum >= 0; raspberriesNum--) {

                    double juice = (cherriesNum * cherryJuice) + (strawberriesNum * strawberryJuice) + (raspberriesNum * raspberryJuice);

                    if (juice == maxJuice) {
                        System.out.printf(
                                "%d Raspberries, %d Strawberries, %d Cherries. Juice: %.0f ml.",
                                raspberriesNum, strawberriesNum, cherriesNum, maxJuice);

                        return;
                    }
                }
            }
        }*/
    }
}

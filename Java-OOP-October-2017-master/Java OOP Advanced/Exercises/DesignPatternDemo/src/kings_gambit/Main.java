package kings_gambit;

import kings_gambit.contracts.King;
import kings_gambit.contracts.Observer;
import kings_gambit.model.Footman;
import kings_gambit.model.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Observer> kingdom = new LinkedHashMap<>();

        King king = new kings_gambit.model.King(reader.readLine());

        king.attachObserver(king);

        String[] royalGuardsNames = reader.readLine().split("\\s+");
        for (String royalGuardsName : royalGuardsNames) {
            Observer guard = new RoyalGuard(royalGuardsName);
            kingdom.putIfAbsent(royalGuardsName, guard);
            king.attachObserver(guard);
        }

        String[] footmanNames = reader.readLine().split("\\s+");
        for (String footmanName : footmanNames) {
            Observer footman = new Footman(footmanName);
            kingdom.putIfAbsent(footmanName, footman);
            king.attachObserver(footman);
        }

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] commandTokens = line.split("\\s+");

            switch (commandTokens[0]) {
                case "Attack":
                    king.attack();
                    break;
                case "Kill":
                    king.detachObserver(kingdom.get(commandTokens[1]));
                    kingdom.remove(commandTokens[1]);
                    break;
            }
        }
    }
}

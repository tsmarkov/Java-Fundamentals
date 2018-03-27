import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Player> players = new LinkedHashMap<>();

        while (true) {
            String[] input = reader.readLine().split("<->| ");

            if (input[0].equals("osu!")) {
                break;
            }

            String firstPlayerName = input[1];
            Integer firstPlayerScore = Integer.parseInt(input[0]);

            String secondPlayerName = input[2];
            Integer secondPlayerScore = Integer.parseInt(input[3]);

            if (!players.containsKey(firstPlayerName)) {
                players.put(firstPlayerName, new Player(firstPlayerName));
            }

            if (!players.containsKey(secondPlayerName)) {
                players.put(secondPlayerName, new Player(secondPlayerName));
            }

            Player firstPlayer = players.get(firstPlayerName);
            Player secondPlayer = players.get(secondPlayerName);

            if (firstPlayerScore > secondPlayerScore) {
                int scoreDif = firstPlayerScore - secondPlayerScore;

                firstPlayer.addBattle(secondPlayerName, scoreDif);

                secondPlayer.addBattle(firstPlayerName, scoreDif * -1);
            } else {
                int scoreDif = secondPlayerScore - firstPlayerScore;

                firstPlayer.addBattle(secondPlayerName, scoreDif * -1);

                secondPlayer.addBattle(firstPlayerName, scoreDif);
            }
        }

        players = players.entrySet().stream()
                .sorted((a, b) -> {
                    return b.getValue().compareTo(a.getValue());
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Player player : players.values()) {
            System.out.print(player.toString());
        }
    }
}

class Player implements Comparable<Player> {
    private String name;
    private long totalScore;
    private List<String> battles;

    Player(String name) {
        this.name = name;
        this.totalScore = 0;
        this.battles = new ArrayList<>();
    }

    private long getTotalDifScore() {
        return this.totalScore;
    }

    private void addScore(long score) {
        this.totalScore += score;
    }

    public void addBattle(String enemy, int scoreDif) {
        this.battles.add(String.format("%s <-> %d", enemy, scoreDif));
        this.addScore(scoreDif);
    }

    @Override
    public int compareTo(Player other) {
        return Long.compare(this.getTotalDifScore(), other.getTotalDifScore());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - (%d)", this.name, this.getTotalDifScore()))
                .append(System.lineSeparator());

        for (String entry : battles) {
            sb.append(String.format("*   %s", entry))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}

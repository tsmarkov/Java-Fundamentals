import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TheDharmaInitiative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Recruit>> stations = new LinkedHashMap<>();
        stations.put("Hydra", new ArrayList<>());
        stations.put("Arrow", new ArrayList<>());
        stations.put("Flame", new ArrayList<>());
        stations.put("Pearl", new ArrayList<>());
        stations.put("Orchid", new ArrayList<>());

        while (true) {
            String[] command = reader.readLine().split(":");

            if (command[0].equals("Recruit")) {
                break;
            }

            if (stations.containsKey(command[2])) {
                Recruit newRecruit = new Recruit(command[0], Long.parseLong(command[1]));

                stations.get(command[2]).add(newRecruit);
            }
        }

        String command = reader.readLine();

        StringBuilder output = new StringBuilder();

        if (command.equals("DHARMA Initiative")) {
            //Sort stations
            stations = stations.entrySet().stream()
                    .sorted((a, b) -> {
                        int c = Integer.compare(b.getValue().size(), a.getValue().size());

                        return c == 0 ? a.getKey().compareTo(b.getKey()) : c;
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));

            //Foreach stations and add info in stringBuilder
            for (Map.Entry<String, List<Recruit>> stringListEntry : stations.entrySet()) {
                output.append(
                        String.format("The %s has %d DHARMA recruits in it.",
                                stringListEntry.getKey(), stringListEntry.getValue().size()))
                        .append(System.lineSeparator());
            }
        } else {
            switch (command) {
                case "Hydra":
                    output.append("The Hydra station: Zoological Research.").append(System.lineSeparator());
                    break;
                case "Arrow":
                    output.append("The Arrow station: Development of defensive strategies, and Intelligence gathering.").append(System.lineSeparator());
                    break;
                case "Flame":
                    output.append("The Flame station: Communication.").append(System.lineSeparator());
                    break;
                case "Pearl":
                    output.append("The Pearl station: Psychological Research and/or Observation.").append(System.lineSeparator());
                    break;
                case "Orchid":
                    output.append("The Orchid station: Space-time manipulation research, disguised as a Botanical station.").append(System.lineSeparator());
                    break;
                default:
                    System.out.println("DHARMA Initiative does not have such a station!");
                    return;
            }

            if (stations.get(command).isEmpty()) {
                output.append("No recruits.");
            } else {
                for (Recruit recruit : stations.get(command).stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList())) {
                    output.append(recruit.toString()).append(System.lineSeparator());
                }
            }
        }

        System.out.print(output.toString());
    }
}

class Recruit implements Comparable<Recruit> {
    private String name;
    private long facilityNumber;

    Recruit(String name, long facilityNumber) {
        this.name = name;
        this.facilityNumber = facilityNumber;
    }

    @Override
    public String toString() {
        return String.format("###%s - %d", this.name, this.facilityNumber);
    }

    @Override
    public int compareTo(Recruit other) {
        return Long.compare(other.facilityNumber, this.facilityNumber);
    }
}

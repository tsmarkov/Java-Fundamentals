package oct_22_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class V_Logger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Vlogger> vloggers = new TreeMap<>();

        while (true) {
            String[] command = reader.readLine().split("\\s+");

            if (command[0].equals("Statistics")) {
                break;
            } else if (command[1].equals("followed")) {
                if (vloggers.containsKey(command[0]) && vloggers.containsKey(command[2])) {
                    vloggers.get(command[2]).addFollower(vloggers.get(command[0]));
                }
            } else if (command[1].equals("joined")) {
                if (!vloggers.containsKey(command[0])) {
                    Vlogger vlogger = new Vlogger(command[0]);
                    vloggers.put(command[0], vlogger);
                }
            }
        }

        vloggers = vloggers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new));


        System.out.println(String.format("The V-Logger has a total of %d vloggers in its logs.", vloggers.size()));

        int counter = 1;

        for (Vlogger vlogger : vloggers.values()) {
            if (counter != 1) {
                System.out.println(
                        String.format("%d. %s : %d followers, %d following",
                                counter, vlogger.getName(), vlogger.getFollowers().size(), vlogger.getFollowingsCount()));
            } else {
                System.out.println(String.format("1. %s : %d followers, %d following",
                        vlogger.getName(), vlogger.getFollowers().size(), vlogger.getFollowingsCount()));

                for (Vlogger follower : vlogger.getFollowers().values()) {
                    System.out.println("*  " + follower.getName());
                }
            }
            counter++;
        }

    }
}

class Vlogger implements Comparable<Vlogger> {
    private String name;
    private Map<String, Vlogger> followers;
    private int followingsCount;

    public Vlogger(String name) {
        this.name = name;
        this.followers = new TreeMap<>();
        this.followingsCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Vlogger> getFollowers() {
        return this.followers;
    }

    public int getFollowingsCount() {
        return this.followingsCount;
    }

    public boolean addFollower(Vlogger vlogger) {
        if (!this.followers.containsKey(vlogger.getName()) && !vlogger.getName().equals(this.getName())) {
            this.followers.put(vlogger.getName(), vlogger);
            vlogger.addFollowing();
            return true;
        }

        return false;
    }

    private void addFollowing() {
        this.followingsCount++;
    }

    @Override
    public int compareTo(Vlogger vlogger) {
        int comp = Integer.compare(this.followers.size(), vlogger.followers.size());

        switch (comp) {
            case 0:
                return Integer.compare(this.getFollowingsCount(), vlogger.getFollowingsCount());
            case 1:
                return -1;
            case -1:
                return 1;
            default:
                return comp;
        }
    }
}

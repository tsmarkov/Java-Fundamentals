import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Earthquake {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ArrayDeque<ArrayDeque<Integer>> activities = registerActivities();

        List<Integer> seismicities = getSeismicities(activities);

        printSeimicities(seismicities);
    }

    private static void printSeimicities(List<Integer> seismicities) {
        System.out.println(seismicities.size());

        for (Integer seismicity : seismicities) {
            System.out.print(seismicity + " ");
        }
    }

    private static List<Integer> getSeismicities(ArrayDeque<ArrayDeque<Integer>> activities) {
        List<Integer> a = new ArrayList<>();

        while (!activities.isEmpty()) {
            ArrayDeque<Integer> deque = activities.pollFirst();

            int currentSeismicity = deque.pollFirst();
            a.add(currentSeismicity);


            for (Integer integer : deque) {
                int currentActivity = deque.pollFirst();

                if (currentActivity > currentSeismicity) {
                    deque.addFirst(currentActivity);
                    break;
                }
            }

            if (!deque.isEmpty()) {
                activities.addLast(deque);
            }

        }

        return a;
    }

    private static ArrayDeque<ArrayDeque<Integer>> registerActivities() throws IOException {
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<ArrayDeque<Integer>> activities = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            ArrayDeque<Integer> newDeque = new ArrayDeque<>();

            String[] input = reader.readLine().split(" ");
            for (String s : input) {
                newDeque.add(Integer.parseInt(s));
            }

            activities.addLast(newDeque);
        }

        return activities;
    }
}

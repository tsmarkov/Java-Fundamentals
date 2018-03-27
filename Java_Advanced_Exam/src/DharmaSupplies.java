import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DharmaSupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> lines = new ArrayList<>();

        while (true) {
            String input = reader.readLine();

            //while loop end
            if (input.equals("Collect")) {
                break;
            }

            lines.add(input);
        }

        List<String> crates = new ArrayList<>();

        Pattern simpleCratePattern = Pattern.compile("\\[.*?\\]");
        for (String line : lines) {
            Matcher crateMatcher = simpleCratePattern.matcher(line);

            while (crateMatcher.find()) {
                crates.add(crateMatcher.group(0));
            }
        }

        int validCrates = 0;
        int amountOfFood = 0;
        int amountOfDrink = 0;


        Pattern supplyTagPattern = Pattern.compile("#(?<tag>[a-z0-9]+)\\]");
        for (String input : crates) {

            int supplyTagLength = crates.size() / lines.size();

            //find supply tag
            String tag = "";
            Matcher tagMatcher = supplyTagPattern.matcher(input);
            if (tagMatcher.find()) {
                tag = tagMatcher.group("tag");
            }

            Pattern cratePattern = Pattern.compile(
                    String.format("\\[#(?<supplyTag>%s{%d})(?<supplyBody>[\\s\\w]*)#(?<supplyTag>%s{%d})\\]",
                            tag, supplyTagLength, tag, supplyTagLength));

            Matcher cratesMatcher = cratePattern.matcher(input);

            String supplyTag = "";
            String supplyBody = "";

            if (cratesMatcher.find()) {
                supplyTag = cratesMatcher.group("supplyTag");
                supplyBody = cratesMatcher.group("supplyBody");
            }

            if ((supplyTag.isEmpty() && supplyTagLength > 0) || supplyBody.isEmpty()) {
                continue;
            }

            validCrates++;

            Pattern digits = Pattern.compile("[0-9]+");
            Pattern letters = Pattern.compile("[a-b]+");

            Matcher m1 = digits.matcher(tag);
            Matcher m2 = letters.matcher(tag);

            if (m1.find()) {
                //AmountDrink
                int tagSum = 0;
                for (char c : supplyTag.toCharArray()) {
                    tagSum += c;
                }

                int bodySum = 0;
                for (char c : supplyBody.toCharArray()) {
                    bodySum += c;
                }

                amountOfDrink = tagSum * bodySum;
            }

            if (m2.find()) {
                //AmountFood
                int bodySum2 = 0;

                Set<Character> chars = new HashSet<>();
                for (char c : supplyBody.toCharArray()) {
                    if (!chars.contains(c)) {
                        bodySum2 += c;
                    }

                    chars.add(c);
                }

                amountOfDrink = supplyTag.length() * bodySum2;
            }
        }
    }
}


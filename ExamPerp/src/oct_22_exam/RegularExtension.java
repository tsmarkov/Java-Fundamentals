package oct_22_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtension {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        Pattern p;
        Matcher m;
        String pattern;

        while (true) {
            pattern = reader.readLine();

            if (pattern.equals("Print")) {
                break;
            }

            if (pattern.contains("%") && !text.contains("%")) {
                pattern = pattern.replaceAll("%", "[^ ]*");
            }

            if (pattern.contains(".")) {
                pattern = pattern.replace(".", "\\.");
            }


            p = Pattern.compile(pattern);
            m = p.matcher(text);

            while (m.find()) {
                String match = m.group();
                text = text.replace(match, new StringBuilder(match).reverse().toString());
            }

        }

        System.out.println(text);
    }
}

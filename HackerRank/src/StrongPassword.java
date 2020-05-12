import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Strong Password (https://www.hackerrank.com/challenges/strong-password/problem)
 */
public class StrongPassword {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String password = sc.nextLine();

        int ans = 0;

        Pattern patternDigit = Pattern.compile("(\\d)");
        Pattern patternUpper = Pattern.compile("([A-Z])");
        Pattern patternLower = Pattern.compile("([a-z])");
        Pattern patternSpecial = Pattern.compile("(\\W)");

        Matcher matcherDigit = patternDigit.matcher(password);
        Matcher matcherUpper = patternUpper.matcher(password);
        Matcher matcherLower = patternLower.matcher(password);
        Matcher matcherSpecial = patternSpecial.matcher(password);

        if (!matcherDigit.find()) ans++;
        if (!matcherUpper.find()) ans++;
        if (!matcherLower.find()) ans++;
        if (!matcherSpecial.find()) ans++;
        if ((ans + password.length()) < 6) ans = ans + 6 - (ans + password.length());

        System.out.println(ans);
        sc.close();
    }
}

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 단어 뒤집기 2 (https://www.acmicpc.net/problem/17413)
 */
public class BOJ_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        Pattern pattern = Pattern.compile("<[^>]*>|[^<>]+");
        Matcher matcher = pattern.matcher(s);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String group = matcher.group();
            if (group.startsWith("<")) {
                sb.append(group);
            } else {
                String[] words = group.split(" ");
                StringBuilder temp = new StringBuilder();
                for (String word : words) {
                    StringBuilder reverse = new StringBuilder(word).reverse();
                    temp.append(reverse.append(" "));
                }
                sb.append(temp.toString().trim());
            }
        }

        System.out.println(sb.toString());
        sc.close();
    }
}

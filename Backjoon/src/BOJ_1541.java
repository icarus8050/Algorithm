import java.util.Scanner;

/**
 * 잃어버린 괄호 (https://www.acmicpc.net/problem/1541)
 */
public class BOJ_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int result = 0;

        int idx = s.indexOf("-");
        if (idx == -1) {
            String[] strings = s.split("[+]");
            for (String num : strings) {
                result += Integer.parseInt(num);
            }
        } else {
            String[] pluses = s.substring(0, idx).split("[+]");
            String[] minuses = s.substring(idx + 1).split("[+-]");
            for (String plus : pluses) {
                result += Integer.parseInt(plus);
            }
            for (String minus : minuses) {
                result -= Integer.parseInt(minus);
            }
        }

        System.out.println(result);
        sc.close();
    }
}

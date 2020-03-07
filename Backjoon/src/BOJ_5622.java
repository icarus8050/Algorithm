import java.util.Arrays;
import java.util.Scanner;

/**
 * 다이얼 (https://www.acmicpc.net/problem/5622)
 */
public class BOJ_5622 {
    public static void main(String[] args) {
        int[] mapping = new int[26];
        Arrays.fill(mapping, 0, 3, 3);
        Arrays.fill(mapping, 3, 6, 4);
        Arrays.fill(mapping, 6, 9, 5);
        Arrays.fill(mapping, 9, 12, 6);
        Arrays.fill(mapping, 12, 15, 7);
        Arrays.fill(mapping, 15, 19, 8);
        Arrays.fill(mapping, 19, 22, 9);
        Arrays.fill(mapping, 22, 26, 10);

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int ans = 0;

        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            ans += mapping[aChar - 65];
        }

        System.out.println(ans);
        sc.close();
    }
}

import java.util.Scanner;

/**
 * 음계 : https://www.acmicpc.net/problem/2920
 */
public class BOJ_2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[8];
        String answer = null;

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        int count = 1;
        for (int i = 0; i < num.length; i++) {
            if (count++ != num[i]) break;

            if (i == num.length - 1) {
                answer = "ascending";
            }
        }

        count = 8;
        for (int i = 0; i < num.length; i++) {
            if (count-- != num[i]) break;

            if (i == num.length - 1) {
                answer = "descending";
            }
        }

        if (answer != null) {
            System.out.println(answer);
        } else {
            System.out.println("mixed");

        }
        sc.close();
    }
}

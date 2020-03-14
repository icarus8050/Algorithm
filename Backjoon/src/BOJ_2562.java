import java.util.Scanner;

/**
 * 최대값 (https://www.acmicpc.net/problem/2562)
 */
public class BOJ_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int seq = 0;

        for (int i = 1; i <= 9; i++) {
            int input = sc.nextInt();
            if (input > max) {
                max = input;
                seq = i;
            }
        }

        System.out.println(max);
        System.out.println(seq);
        sc.close();
    }
}

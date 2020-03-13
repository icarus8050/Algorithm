import java.util.Scanner;

/**
 * 손익분기점 (https://www.acmicpc.net/problem/1712)
 */
public class BOJ_1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();

        long benefit = c - b;

        if (benefit <= 0) {
            System.out.println(-1);
        } else {
            System.out.println((a / benefit) + 1);
        }

        sc.close();
    }
}

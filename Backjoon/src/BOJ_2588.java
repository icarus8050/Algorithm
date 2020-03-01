import java.util.Scanner;

/**
 * 곱셈 (https://www.acmicpc.net/problem/2588)
 */
public class BOJ_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = sc.nextInt();
        int second = sc.nextInt();

        System.out.println(first * (second % 10));
        System.out.println(first * (second / 10 % 10));
        System.out.println(first * (second / 100 % 10));
        System.out.println(first * second);
        sc.close();
    }
}

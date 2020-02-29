import java.util.Scanner;

/**
 * 피보나치 수5 (https://www.acmicpc.net/problem/10870)
 */
public class BOJ_10870 {

    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new long[n + 1];

        System.out.println(fibonacci(n));

        sc.close();
    }

    public static long fibonacci(int n) {
        if (n == 0) return 0L;
        if (n == 1) return 1L;

        if (arr[n] == 0)
            arr[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return arr[n];
    }
}

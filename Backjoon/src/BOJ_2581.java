import java.util.Arrays;
import java.util.Scanner;

/**
 * 소수 (https://www.acmicpc.net/problem/2581)
 */
public class BOJ_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, 2, N + 1, true);

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int sum = 0;
        int min = 10_001;

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if (sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }
}

import java.util.Scanner;

/**
 * 평균 점수 (https://www.acmicpc.net/problem/10039)
 */
public class BOJ_10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int score = sc.nextInt();

            if (score < 40) {
                sum += 40;
            } else {
                sum += score;
            }
        }

        System.out.println(sum / 5);

        sc.close();
    }
}

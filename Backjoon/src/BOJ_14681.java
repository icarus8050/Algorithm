import java.util.Scanner;

/**
 * 사분면 고르기 (https://www.acmicpc.net/problem/14681)
 */
public class BOJ_14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x > 0 && y > 0) System.out.println(1);
        else if (0 > x && y > 0) System.out.println(2);
        else if (x > 0 && y < 0) System.out.println(4);
        else System.out.println(3);

        sc.close();
    }
}

import java.util.Scanner;

/**
 * 두 수 비교하기 (https://www.acmicpc.net/problem/1330)
 */
public class BOJ_1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) System.out.println(">");
        else if (a < b) System.out.println("<");
        else System.out.println("==");

        sc.close();
    }
}

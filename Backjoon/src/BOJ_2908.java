import java.util.Scanner;

/**
 * 상수 (https://www.acmicpc.net/problem/2908)
 */
public class BOJ_2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuffer a = new StringBuffer(sc.next());
        StringBuffer b = new StringBuffer(sc.next());

        int first = Integer.parseInt(a.reverse().toString());
        int second = Integer.parseInt(b.reverse().toString());

        int ans = Math.max(first, second);
        System.out.println(ans);
        sc.close();
    }
}

import java.util.Scanner;

/**
 * Strange Counter (https://www.hackerrank.com/challenges/strange-code/problem)
 */
public class StrangeCounter {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();
        long scope = 3L;
        long idx = 1L;

        while (t > scope) {
            scope = 3L * ((long) (Math.pow(2L, idx++) - 1L));
        }

        System.out.println(scope - t + 1);

        sc.close();
    }
}

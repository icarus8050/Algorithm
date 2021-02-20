import java.util.Scanner;

/**
 * Cubeditor (https://www.acmicpc.net/problem/1701)
 */
public class Cubeditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int max = 0;

        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String sub = s.substring(i, j + 1);
                int idx = s.lastIndexOf(sub);

                if (idx != i) {
                    max = Math.max(max, j - i + 1);
                }

                if (j - i + 1 >= length / 2) {
                    break;
                }
            }
        }

        System.out.println(max);

        sc.close();
    }
}

import java.util.Scanner;

/**
 * Super Reduced String (https://www.hackerrank.com/challenges/reduced-string/problem)
 */
public class SuperReducedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);

        boolean flag = true;
        while (flag) {
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    break;
                }

                if (i == sb.length() - 2) {
                    flag = false;
                }
            }

            if (sb.length() == 0) {
                flag = false;
            }
        }

        if (sb.length() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println(sb.toString());
        }

        sc.close();
    }
}

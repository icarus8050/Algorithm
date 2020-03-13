import java.util.Scanner;

/**
 * 상근날드 (https://www.acmicpc.net/problem/5543)
 */
public class BOJ_5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bugger = 10000;
        int beverage = 10000;

        bugger = Math.min(bugger, sc.nextInt());
        bugger = Math.min(bugger, sc.nextInt());
        bugger = Math.min(bugger, sc.nextInt());

        beverage = Math.min(beverage, sc.nextInt());
        beverage = Math.min(beverage, sc.nextInt());

        System.out.println(bugger + beverage - 50);

        sc.close();
    }
}

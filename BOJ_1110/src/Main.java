import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int origin = n;
		int cnt = 0;
		while (true) {
			int temp = n;
			int second = n;
			if (temp > 9) {
				second = temp % 10;
				temp /= 10;
				second += temp % 10;
			}
			n = n % 10 * 10 + second % 10;
			cnt++;
			if (n == origin)
				break;
		}
		System.out.println(cnt);
		sc.close();
	}
}

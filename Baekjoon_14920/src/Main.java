import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(C(n, 1));
		sc.close();
	}
	
	public static int C(int a, int cnt) {
		if (a == 1)
			return cnt;
		
		if (a % 2 == 0) {
			return C(a / 2, cnt + 1);
		} else {
			return C(3 * a + 1, cnt + 1);
		}
	}
}
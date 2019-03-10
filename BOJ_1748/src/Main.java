import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int ans = 0;
		
		for (int i = 1; i <= N; i++) {
			int cnt = 1;
			int j = i;
			
			while (j / 10 != 0) {
				cnt++;
				j /= 10;
			}
			ans += cnt;
		}
		System.out.println(ans);
	}
}

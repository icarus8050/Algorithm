import java.util.Scanner;

public class Main {

	static long[] cost = new long[100001];
	static int N;
	static long ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			ans = 0;
			
			for (int i = 0; i < N; i++)
				cost[i] = sc.nextLong();
			
			long max = 0L;
			for (int i = N - 1; i >= 0; i--) {
				if (max > cost[i])
					ans += (max - cost[i]);
				else
					max = cost[i];
					
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
}

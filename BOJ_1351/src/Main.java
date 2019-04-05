import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static long N;
	static long P;
	static long Q;
	static Map<Long, Long> dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextLong();
		P = sc.nextLong();
		Q = sc.nextLong();
		dp = new HashMap<>();
		
		dp.put(0L, 1L);
		System.out.println(dfs(N));
		
		sc.close();
	}
	
	public static Long dfs(long n) {
		if (dp.containsKey(n)) {
			return dp.get(n);
		} else {
			dp.put(n, dfs(n / P) + dfs(n / Q));
			return dp.get(n);
		}
	}
}

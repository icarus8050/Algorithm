import java.util.Scanner;

public class Main {

	static final int MOD = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long x = sc.nextLong();
		long ans = 1;
		
		a %= MOD;
		
		while (x > 0) {
			if ((x & 1) == 1)
				ans = (ans * a) % MOD;
			
			a = (a * a) % MOD;
			x >>= 1;
		}
		
		System.out.println(ans);
		sc.close();
	}
}

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println(solve(n));
	}
	
	public static BigInteger solve(int n) {
		if (n == 0)
			return BigInteger.ZERO;
		
		else if (n == 1)
			return BigInteger.ONE;
		
		else {
			BigInteger a = BigInteger.ZERO;
			BigInteger b = BigInteger.ONE;
			BigInteger c = BigInteger.ONE;
			
			for (int i = 2; i <= n; i++) {
				c = a.add(b);
				a = b;
				b = c;
			}
			return c;
		}
	}
}

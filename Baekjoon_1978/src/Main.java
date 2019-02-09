import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int primeCount = 0;
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if (isPrime(num))
				primeCount++;
		}
		System.out.println(primeCount);
	}
	
	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		
		return true;
	}
}

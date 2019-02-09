import java.util.Scanner;

public class Main {

	public static final int MAX = 1000000;
	public static boolean[] isNotPrime = new boolean[MAX + 1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder res = new StringBuilder();
		
		//에라토스테네스의 체
		isNotPrime[1] = true;
		for (int i = 2; i * i < MAX; i++) {
			if(!isNotPrime[i]) {
				for (int j = i * i; j < MAX; j += i) 
				{
					isNotPrime[j] = true;
				}
			}
		}
		
		while(true) {
			int n = sc.nextInt();
			
			if (n == 0)
				break;
			
			res.append(goldBach(n));
		}
		
		System.out.println(res.toString());
		sc.close();
	}
	
	public static String goldBach(int n) {
		
		for (int i = 3; i <= n / 2; i++) {
			if (!isNotPrime[i] && !isNotPrime[n - i]) {
				return String.format("%d = %d + %d\n", n, i, n - i);
			}
		}
		return "Goldbach's conjecture is wrong.\n";
	}
}

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		boolean[] isPrime = new boolean[10001];
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i * i <= 10000; i++) {
			if (isPrime[i]) {
				for (int j = 2; i * j <= 10000; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		
		for (int i = 0; i < testCase; i++) {
			int n = sc.nextInt();
			int min = 10000;
			int[] result = new int[2];
			
			for (int num_1 = 2; num_1 <= n / 2; num_1++) {
				if (!isPrime[num_1])
					continue;
				
				int num_2 = n - num_1;
				if (isPrime[num_2] && min > (num_2 - num_1)) {
					min = num_2 - num_1;
					result[0] = num_1;
					result[1] = num_2;
				}
			}
			System.out.println(result[0] + " " + result[1]);
		}
	}
}

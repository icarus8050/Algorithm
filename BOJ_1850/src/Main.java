import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		long len = getGCD(a, b);
		
		for (int i = 0; i < len; i++)
			sb.append(1);
		
		System.out.println(sb);
		sc.close();
	}
	
	public static long getGCD(long a, long b) {
		while (b > 0) {
			long temp = a;
			a = b;
			b = temp % b;
		}
		
		return a;
	}
}

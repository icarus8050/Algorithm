import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr;
		int result = 0;
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		for (int i = N - 1; i >= 0; i--) {
			result += K / arr[i];
			K %= arr[i];
		}
		
		System.out.println(result);
	}
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		boolean[] visited = new boolean[N];
		int max_index, max_value;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(A);
		int[] temp = A.clone();
		
		for (int i = 0; i < N; i++) {
			max_index = -1;
			max_value = -1;
			
			for (int j = 0; j < N; j++) {
				if (!visited[j] && B[j] > max_value) {
					max_index = j;
					max_value = B[j];
				}
			}
			
			A[max_index] = temp[i];
			visited[max_index] = true;
		}
		
		for (int i = 0; i < N; i++) {
			result += A[i] * B[i];
		}
		
		System.out.println(result);
	}
}

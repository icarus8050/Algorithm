import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		if (M + K - 1 <= N && N <= M * K) {
			Integer[] arr = new Integer[N];
			for (int i = 0; i < N; i++)
				arr[i] = i + 1;
			
			ArrayList<Integer> splitList = new ArrayList<Integer>();
			splitList.add(0);
			splitList.add(K);
			M--;
			N -= K;
			
			for (int i = M; i >= 1; i--) {
				int a = N / i;
				splitList.add(splitList.get(splitList.size() - 1) + a);
				N -= a;
			}
			for (int i = 0; i < splitList.size() - 1; i++)
				Arrays.sort(arr, splitList.get(i), splitList.get(i + 1), Collections.reverseOrder());
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
		sc.close();
	}
}

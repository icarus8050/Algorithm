import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] budget = new int[N];
		int low = 1;
		int high = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, budget[i]);
		}
		int M = Integer.parseInt(br.readLine());
		
		while (low <= high) {
			int mid = (low + high) / 2;
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				sum += (budget[i] > mid ? mid : budget[i]);
			}
			
			if (sum > M)
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		System.out.println(high);
		br.close();
	}
}

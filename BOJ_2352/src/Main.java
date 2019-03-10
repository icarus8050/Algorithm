import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] dp;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(lis());
		
		br.close();
	}
	public static int lis() {
		dp[1] = arr[1];
		int len = 1;
		
		for (int i = 2; i <= N; i++) {
			if (arr[i] > dp[len]) {
				dp[++len] = arr[i];
			}
			else {
				int index = lower_bound(1, len, arr[i]);
				dp[index] = arr[i];
			}
		}
		
		return len;
	}
	public static int lower_bound(int front, int end, int key) {
		int mid;
		
		while (front < end) {
			mid = (front + end) / 2;
			if (dp[mid] < key)
				front = mid + 1;
			else
				end = mid;
		}
		return end;
	}
}

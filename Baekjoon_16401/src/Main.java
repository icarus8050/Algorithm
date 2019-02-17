import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static int[] snack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int low = 1;
		int high = 0;
		int result = 0;
		
		snack = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, snack[i]);
		}
		
		while (high >= low) {
			int mid = (low + high) / 2;
			
			if (check(mid)) {
				result = mid;
				low = mid + 1;
			}
				
			else {
				high = mid - 1;
			}
		}
		System.out.println(result);
		br.close();
	}
	
	public static boolean check(int len) {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			cnt += snack[i] / len;
		}
		if (cnt >= M) return true;
		else return false;
	}
}

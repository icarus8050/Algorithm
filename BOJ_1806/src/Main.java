import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0, e = 0;
		int ans = 1000000, sum = 0;
		while (e <= N) {
			if (sum >= S) {
				ans = Math.min(ans, e - s);
				sum -= arr[s++];
			}
			else if (e == N)
				break;
			else {
				sum += arr[e++];
			}
		}
		if (ans == 1000000)
			ans = 0;
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

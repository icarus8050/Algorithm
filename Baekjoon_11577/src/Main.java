import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] lights = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			lights[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N - K; i++) {
			if (lights[i] == 1) {
				for (int j = 0; j < K; j++)
					lights[i + j] ^= 1;
				
				result++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (lights[i] == 1) {
				result = INF;
				break;
			}
		}
		System.out.println((result != INF) ? result : "Insomnia");
		br.close();
	}
}

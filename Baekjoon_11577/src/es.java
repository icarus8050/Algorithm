import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class es {

	static int INF = Integer.MAX_VALUE;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] lights = new int[N];
		int[] rev = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			lights[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			if (rev[i] != 0) lights[i] ^= 1;
			if (lights[i] != 0) {
				lights[i] ^= 1;
				rev[i] ^= 1;
				cnt++;
				if (i + K > N) {
					System.out.println("Insomnia");
					return;
				}
				if (i + K < N) rev[i + K] ^= 1;
			}
			if (i < N - 1) {
				int temp;
				if ((rev[i] & 1) != 0)
					temp = 1;
				else
					temp = 0;
				rev[i + 1] ^= temp;
			}
		}
		for (int i = 0; i < N; i++) {
			if (lights[i] == 1) {
				System.out.println("Insomnia");
				return;
			}
		}
		System.out.println(cnt);
	}

}

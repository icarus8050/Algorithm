import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_Ver {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] gray = new int[N];
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		gray[0] = arr[0];
		for (int i = 1; i < N; i++)
			gray[i] = arr[i - 1] ^ arr[i];
		
		for (int i = 0; i <= N - K; i++) {
			if (gray[i] == 1) {
				gray[i] ^= 1;
				
				if (i + K < N)
					gray[i + K] ^= 1;
				
				result++;
			}
		}
		
		for (int i = N - K + 1; i < N; i++) {
			if (gray[i] == 1) {
				System.out.println("Insomnia");
				return;
			}
		}
		System.out.println(result);
		br.close();
	}
}

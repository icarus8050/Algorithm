import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int idx = -1;
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				idx = i;
				break;
			}
		}
		
		if (idx != -1) {
			for (int i = N - 1; i > idx; i--) {
				if (arr[i] > arr[idx]) {
					int temp = arr[idx];
					arr[idx] = arr[i];
					arr[i] = temp;
					break;
				}
			}
			Arrays.sort(arr, idx + 1, N);
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) 
				sb.append(arr[i]).append(" ");
			System.out.println(sb);
		}
		else
			System.out.println(-1);
		
		br.close();
	}
}

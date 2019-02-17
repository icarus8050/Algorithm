import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int result = 0;
		
		String[] s = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(s[i]);
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			result += arr[i] * (N - i);
		}
		System.out.println(result);
		br.close();
	}
}

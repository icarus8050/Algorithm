import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int result = 0;
		
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int left, right;
		
		for (left = 0; left < N - 1 && arr[left + 1] < 1; left += 2)
			result += arr[left] * arr[left + 1];
		
		for (right = N - 1; right > 0 && arr[right - 1] > 1; right -= 2)
			result += arr[right] * arr[right - 1];
		
		for (; left <= right; left++)
			result += arr[left];
		
		System.out.println(result);
		br.close();
		
	}
}

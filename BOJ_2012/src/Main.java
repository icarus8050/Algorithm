import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		long res = 0;
		for (int i = 1; i <= N; i++) 
			res += Math.abs(i - arr[i]);
			
		System.out.println(res);
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class nondp {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int result = 0;
		int j;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = n; i > 1; i--) {
			for (j = 1; j <= n; j++)
				if (arr[j] == i) break;
			
			result += arr[j] - Math.max(arr[j - 1], arr[j + 1]);
			
			for (; j <= n; j++) arr[j] = arr[j + 1];
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

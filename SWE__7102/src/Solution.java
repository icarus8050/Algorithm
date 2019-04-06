import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] sum = new int[N + M + 1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					sum[i + j]++;
				}
			}
			
			int max = Arrays.stream(sum).max().getAsInt();
			List<String> list = new ArrayList<>();
			
			for (int i = 2; i <= N + M; i++) {
				if (sum[i] == max) {
					list.add(Integer.toString(i));
				}
			}
			
			bw.write("#" + t + " " + String.join(" ", list) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

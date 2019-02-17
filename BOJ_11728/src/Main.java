import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new int[N + M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = N; i < N + M; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N + M; i++)
			sb.append(A[i]).append(" ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!hm.containsKey(num))
				hm.put(num, 1);
			else
				hm.put(num, hm.get(num) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (hm.containsKey(num))
				sb.append(hm.get(num) + " ");
			else
				sb.append(0 + " ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class HashSetVer {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> hs = new HashSet<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			if (hs.contains(Integer.parseInt(st.nextToken())))
				sb.append("1 ");
			else
				sb.append("0 ");
		}
		System.out.println(sb);
		br.close();
	}
}

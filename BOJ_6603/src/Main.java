import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int k;
	static int[] s;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if (k == 0)
				break;
			
			s = new int[k + 1];
			visited = new boolean[k + 1];
			for (int i = 1; i <= k; i++)
				s[i] = Integer.parseInt(st.nextToken());
			
			dfs(0, 0);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int num, int cnt) {
		if (cnt == 6) {
			for (int i : list)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = num + 1; i <= k; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				list.add(s[i]);
				dfs(i, cnt + 1);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}
}

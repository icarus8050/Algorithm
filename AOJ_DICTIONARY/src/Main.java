import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[][] adjMat;
	static boolean[] visited;
	static ArrayList<Integer> seq;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		while (C-- > 0) {
			N = Integer.parseInt(br.readLine());
			adjMat = new int[26][26];
			visited = new boolean[26];
			seq = new ArrayList<Integer>();
			String[] words = new String[N];
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for (int i = 0; i < N; i++)
				words[i] = br.readLine();
			
			for (int i = 1; i < N; i++) {
				int j = i - 1;
				int len = Math.min(words[i].length(), words[j].length());
				
				for (int k = 0; k < len; k++) {
					if (words[i].charAt(k) != words[j].charAt(k)) {
						int a = words[j].charAt(k) - 'a';
						int b = words[i].charAt(k) - 'a';
						adjMat[a][b] = 1;
						queue.offer(a);
						break;
					}
				}
			}
			
			while (!queue.isEmpty()) {
				int start = queue.poll();
				if (!visited[start])
					dfs(start);
			}
			
			Collections.reverse(seq);
			boolean flag = true;
			for (int i = 0; i < seq.size(); i++) {
				for (int j = i + 1; j < seq.size(); j++) {
					if (adjMat[seq.get(j)][seq.get(i)] == 1) {
						flag = false;
					}
				}
			}
			
			if (flag) {
				StringBuilder sb = new StringBuilder();
				boolean[] alpha = new boolean[26];
				
				for (int a : seq) {
					if (!alpha[a]) {
						alpha[a] = true;
						char ch = (char) (a + 97);
						sb.append(ch);
					}
				}
				for (int i = 0; i < 26; i++) {
					if (!alpha[i]) {
						char ch = (char) (i + 97);
						sb.append(ch);
					}
				}
				System.out.println(sb);
			}
			else
				System.out.println("INVALID HYPOTHESIS");
		}
		br.close();
	}
	
	public static void dfs(int start) {
		if (visited[start])
			return;
		visited[start] = true;
		for (int there = 0; there < adjMat.length; there++) {
			if (adjMat[start][there] == 1) {
				dfs(there);
			}
		}
		seq.add(start);
	}
}

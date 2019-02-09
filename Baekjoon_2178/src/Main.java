import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[][] matrix;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N, M, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String rowPath = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = rowPath.charAt(j) - '0';
			}
		}
		bfs(new Node(0, 0, 1));
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(Node n) {
		Queue<Node> queue = new LinkedList<>();
		
		visited[n.y][n.x] = true;
		queue.offer(new Node(n.x, n.y, n.depth));
		
		while (!queue.isEmpty()) {
			Node visitNode = queue.poll();
			
			if (visitNode.x == M - 1 && visitNode.y == N - 1) {
				result = visitNode.depth;
			}
			
			for (int i = 0; i < 4; i++) {
				int p_x = visitNode.x + dx[i];
				int p_y = visitNode.y + dy[i];
				
				if (
						p_x >= 0 && p_y >= 0 
						&& p_x < M && p_y < N
						&& visited[p_y][p_x] == false 
						&& matrix[p_y][p_x] == 1
						) 
				{
					visited[p_y][p_x] = true;
					queue.offer(new Node(p_x, p_y, visitNode.depth + 1));
				}
			}
		}
	}
}

class Node {
	int x, y;
	int depth;
	
	public Node(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}
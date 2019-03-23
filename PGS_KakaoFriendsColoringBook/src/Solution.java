import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] visited;
	public int[] solution(int m, int n, int[][] picture) {
	      int[] answer = new int[2];
	      int cnt = 0, max = 0;
	      visited = new boolean[m][n];
	      
	      for (int i = 0; i < m; i++) {
	    	  for (int j = 0; j < n; j++) {
	    		  if (picture[i][j] != 0 && !visited[i][j]) {
	    			  cnt++;
	    			  max = Math.max(max, bfs(j, i, picture));
	    		  }
	    	  }
	      }
	      
	      answer[0] = cnt; answer[1] = max;
	      return answer;
	}
	public int bfs(int x, int y, int[][] picture) {
		int cnt = 1;
		visited[y][x] = true;
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(x, y));
		
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				if (inRange(nx, ny, picture[0].length, picture.length)
						&& picture[ny][nx] == picture[cur.y][cur.x] && !visited[ny][nx]) {
					visited[ny][nx] = true;
					queue.offer(new Pair(nx, ny));
					cnt++;
				}
			}
		}
		return cnt;
	}
	public boolean inRange(int x, int y, int n, int m) {
		return (x >= 0 && x < n && y >= 0 && y < m);
	}
}

class Pair {
	int x, y;
	public Pair(int x, int y) {
		this.x = x; this.y = y;
	}
}
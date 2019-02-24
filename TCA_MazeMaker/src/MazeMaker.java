import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {

	public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
		int max = 0;
		int width = maze[0].length();
		int height = maze.length;
		
		int[][] map = new int[height][width];
		
		for (int i = 0; i < height; i++)
			Arrays.fill(map[i], -1);
		
		Queue<Pair> queue = new LinkedList<Pair>();
		map[startRow][startCol] = 0;
		queue.offer(new Pair(startCol, startRow));
		
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			
			for (int i = 0; i < moveRow.length; i++) {
				int dy = cur.y + moveRow[i];
				int dx = cur.x + moveCol[i];
				
				if (dy >= 0 && dy < height
					&& dx >= 0 && dx < width
					&& maze[dy].charAt(dx) == '.'
					&& map[dy][dx] == -1)
				{
					map[dy][dx] = map[cur.y][cur.x]+ 1;
					queue.offer(new Pair(dx, dy));
				}
			}
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (map[i][j] == -1 && maze[i].charAt(j) == '.')
					return -1;
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}
	class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x; this.y = y;
		}
	}
}

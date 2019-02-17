import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder result = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if (R % 2 == 1) {
			for (int i = 0; i < R; i++) {
				if (i % 2 == 0) {
					move(result, 'R', C - 1);
					if (i != R - 1)
						move(result, 'D', 1);
				} else {
					move(result, 'L', C - 1);
					move(result, 'D', 1);
				}
			}
		} else if(C % 2 == 1) {
			for (int i = 0; i < C; i++) {
				if (i % 2 == 0) {
					move(result, 'D', R - 1);
					if (i != C - 1)
						move(result, 'R', 1);
				} else {
					move(result, 'U', R - 1);
					move(result, 'R', 1);
				}
			}
		} else {
			int x = 0, y = 1;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if ((i + j) % 2 == 1) {
						if (arr[x][y] > arr[i][j]) {
							x = i; y = j;
						}
					}
				}
			}
			
			int x1 = 0, y1 = 0;
			int x2 = R - 1, y2 = C - 1;
			
			while (x2 - x1 > 1) {
				if (x1 / 2 < x / 2) {
					move(result, 'R', C - 1);
					move(result, 'D', 1);
					move(result, 'L', C - 1);
					move(result, 'D', 1);
					x1 += 2;
				}
				if (x / 2 < x2 / 2) {
					move(temp, 'R', C - 1);
					move(temp, 'D', 1);
					move(temp, 'L', C - 1);
					move(temp, 'D', 1);
					x2 -= 2;
				}
			}
			while (y2 - y1 > 1) {
				if (y1 / 2 < y / 2) {
					move(result, 'D', 1);
					move(result, 'R', 1);
					move(result, 'U', 1);
					move(result, 'R', 1);
					y1 += 2;
				}
				if (y / 2 < y2 / 2) {
					move(temp, 'D', 1);
					move(temp, 'R', 1);
					move(temp, 'U', 1);
					move(temp, 'R', 1);
					y2 -= 2;
				}
			}
			
			if (x1 == x) {
				move(result, 'D', 1);
				move(result, 'R', 1);
			} else {
				move(result, 'R', 1);
				move(result, 'D', 1);
			}
			result.append(temp.reverse());
		}
		
		System.out.println(result);
		br.close();
	}
	
	public static void move(StringBuilder sb, char ch, int cnt) {
		for (int i = 0; i < cnt; i++)
			sb.append(ch);
	}
}

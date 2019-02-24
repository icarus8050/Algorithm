import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		String[] inputStr;
		for (int i = 0; i < N; i++) {
			inputStr = br.readLine().split("");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(inputStr[j]);
		}
		
		compress(0, 0, N);
		sb.append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void compress(int x, int y, int len) {
		
		int checkNum = check(x, y, len);
		if (checkNum == -1) {
			sb.append("(");
			int nextLen = len >> 1;
			compress(x, y, nextLen);
			compress(x + nextLen, y, nextLen);
			compress(x, y + nextLen, nextLen);
			compress(x + nextLen, y + nextLen, nextLen);
			sb.append(")");
		}
		else {
			sb.append(checkNum);
		}
	}
	
	public static int check(int x, int y, int len) {
		int temp = map[y][x];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (map[y + i][x + j] != temp)
					return -1;
			}
		}
		return temp;
	}
}

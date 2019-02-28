import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		char[][] board = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		int result = 64;
		
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				
				int cnt = 0;
				for (int y = i; y < i + 8; y++) {
					for (int x = j; x < j + 8; x++) {
						if ((x + y) % 2 == 0) {
							if (board[y][x] == 'W')
								cnt++;
						} else {
							if (board[y][x] == 'B')
								cnt++;
						}
					}
				}
				result = Math.min(result, Math.min(cnt, 64 - cnt));
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

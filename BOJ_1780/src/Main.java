import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] paper;
	static int negative = 0;
	static int zero = 0;
	static int one = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
		divide(0, 0, N);
		System.out.println(negative);
		System.out.println(zero);
		System.out.println(one);
		br.close();
		
	}
	
	public static void divide(int a, int b, int len) {
		if (check(a, b, len)) {
			return;
		} else {
			len /= 3;
			divide(a, b, len);
			divide(a + len, b, len);
			divide(a + len * 2, b, len);
			
			divide(a, b + len, len);
			divide(a + len, b + len, len);
			divide(a + len * 2, b + len, len);
			
			divide(a, b + len * 2, len);
			divide(a + len, b + len * 2, len);
			divide(a + len * 2, b + len * 2, len);
		}
	}
	
	public static boolean check(int a, int b, int len) {
		int temp = paper[a][b];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (paper[a + i][b + j] != temp)
					return false;
			}
		}
		
		if (temp == -1)
			negative++;
		else if (temp == 0)
			zero++;
		else
			one++;
		
		return true;
	}
}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] city = new int[n + 1][n + 1];
		
		
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int value = sc.nextInt();
			
			if (city[from][to] == 0)
				city[from][to] = value;
			else
				city[from][to] = Math.min(city[from][to], value);
		}
		sc.close();
		
		for (int k = 1; k <= n; k++) {
			for (int x = 1; x <= n; x++) {
				if (city[x][k] == 0)
					continue;
				
				for (int y = 1; y <= n; y++) {
					if (city[k][y] == 0 || x == y)
						continue;
					
					if (city[x][y] == 0 ||city[x][y] > city[x][k] + city[k][y])
						city[x][y] = city[x][k] + city[k][y];
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
					System.out.print(city[i][j] + " ");
			}
			System.out.println();
		}
	}
}

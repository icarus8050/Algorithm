import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n, cnt = 0;
		int mat[][];
		Scanner input = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		n = input.nextInt();
		
		mat = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				mat[i][j] = ++cnt;
			}
		}
		
		printMatrix(mat, n);
		rotate(mat, n);
		printMatrix(mat, n);
	}
	
	public static void rotate(int[][] mat, int n) {
		
		for(int i = 0; i < n / 2; i++) {
			
			int first = i;
			int last = n - 1 - i;
			int index = 0;
			
			for(int j = first; j < last; j++) {
				int temp = mat[first][j];
				mat[first][j] = mat[last - index][first];
				mat[last - index][first] = mat[last][last - index];
				mat[last][last - index] = mat[first + index][last];
				mat[first + index][last] = temp;
				index++;
			}
		}
	}
	
	public static void printMatrix(int[][] mat, int n) {
		
		int cnt = 0;
		System.out.println("---------------------------");
		for(int[] row: mat) {
			for(int col: row) {
				if(cnt == n - 1) {
					System.out.println(col);
					cnt = 0;
				}
				else {
					System.out.print(col + ", ");
					cnt++;
				}
				
			}
		}
		System.out.println("---------------------------");
		
	}
}

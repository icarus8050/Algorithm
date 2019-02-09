import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array;
		int N = sc.nextInt();
		
		array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		
		/*for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < N - (i + 1); j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}*/
		for (int i = 1; i < N; i++) {
			int j;
			int temp = array[i];
			
			for (j = i - 1; j >= 0; j--) {
				
				if(array[j] > temp)
					array[j + 1] = array[j];
				else
					break;
			}
			array[j + 1] = temp;
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(array[i]);
		}
	}
}

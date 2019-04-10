import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[10];
		
		int res = a * b * c;
		while (res != 0) {
			arr[res % 10]++;
			res /= 10;
		}
		for (int num : arr) {
			bw.write(num + "\n");
		}
		bw.flush();
		bw.close();
		sc.close();
	}
}

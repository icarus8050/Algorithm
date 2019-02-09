import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] dwarf = new int[9];
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
			result += dwarf[i];
		}
		sc.close();
		
		solve();
		Arrays.sort(dwarf);
		
		for (int i = 2; i < 9; i++)
			System.out.println(dwarf[i]);
	}
	
	public static void solve() {
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (result - (dwarf[i] + dwarf[j]) == 100) {
					dwarf[i] = 0;
					dwarf[j] = 0;
					return;
				}
			}
		}
	}
}

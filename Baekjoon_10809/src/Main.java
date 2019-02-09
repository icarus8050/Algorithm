import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] ary = new int[26];
		
		for (int i = 0; i < ary.length; i++) {
			ary[i] = -1;
		}
		
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 97;
			if (ary[index] == -1) {
				ary[index] = i;
			}
		}
		
		for (int i = 0; i < ary.length; i++) {
			System.out.print(ary[i]);
			System.out.print(" ");
		}
	}
}

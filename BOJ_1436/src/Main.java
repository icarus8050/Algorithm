import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 666;
		int cnt = 1;
		while (cnt != n) {
			int temp = 0;
			num++;
			String str = Integer.toString(num);
			
			for (int i = 0; i < str.length(); i++) {
				if (temp == 3)
					break;
				
				if (str.charAt(i) == '6') {
					if (temp == 0) temp++;
					else if (str.charAt(i - 1) == '6') temp++;
					else temp = 0;
				}
				else temp = 0;
			}
			if (temp == 3)
				cnt++;
		}
		System.out.println(num);
		sc.close();
	}
}

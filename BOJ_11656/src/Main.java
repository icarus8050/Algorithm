import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arrStr = new String[str.length()];
		
		for (int i = 0; i < arrStr.length; i++)
			arrStr[i] = str.substring(i);
		
		Arrays.sort(arrStr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int len = Math.min(o1.length(), o2.length());
				
				for (int i = 0; i < len; i++) {
					if (o1.charAt(i) != o2.charAt(i))
						return o1.charAt(i) - o2.charAt(i);
				}
				return o1.length() > o2.length() ? 1 : -1;
			}
			
		});
		
		for (int i = 0; i < arrStr.length; i++)
			System.out.println(arrStr[i]);
		
		sc.close();
	}
}

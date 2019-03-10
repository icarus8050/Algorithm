import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strNum = br.readLine();
		int len = strNum.length();
		int num = Integer.parseInt(strNum);
		int ans = 0;
		for (int i = num - (len * 9); i <num; i++) {
			int sum = 0;
			int temp = i;
			
			while (temp != 0) {
				sum += temp % 10;
				temp /= 10;
			}
			sum += i;
			if (sum == num) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
		br.close();
	}
}

import java.util.Scanner;

public class Main {
	
	static int cache[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < testCase; i++) {
			int n = sc.nextInt();
			sc.nextLine();
			cache = new int[41][2];
			cache[0][0] = 1;
			cache[1][1] = 1;
			
			int[] result = fibonacci(n);
			System.out.println(result[0] + " " + result[1]);
		}
		
	}

	public static int[] fibonacci(int n) {
		if (cache[n][0] != 0 || cache[n][1] != 0) {
			return cache[n];
			
	    } else {
	    	cache[n][0] += fibonacci(n - 1)[0];
	    	cache[n][1] += fibonacci(n - 1)[1];
	    	
	    	cache[n][0] += fibonacci(n - 2)[0];
	    	cache[n][1] += fibonacci(n - 2)[1];
	        return cache[n];
	    }
	    
	    
	}
}

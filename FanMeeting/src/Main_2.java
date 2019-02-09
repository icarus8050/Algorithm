import java.util.BitSet;
import java.util.Scanner;

public class Main_2 {

	public static int hug(String singer, String fan) {
		BitSet bitset_Singer = new BitSet(singer.length());
		BitSet bitset_Fan = new BitSet(fan.length());
		
		for (int i = 0; i < singer.length(); i++)
			bitset_Singer.set(i, singer.charAt(i) == 'M');
		
		for (int i = 0; i < fan.length(); i++)
			bitset_Fan.set(i, fan.charAt(i) == 'M');
		
		int N = fan.length() - singer.length() + 1;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			BitSet tempBitSet_fan = bitset_Fan.get(i, fan.length() + i);
			if(!tempBitSet_fan.intersects(bitset_Singer))
				result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int testCase;
		String singer = null;
		String fan = null;
		
		Scanner input = new Scanner(System.in);
		testCase = input.nextInt();
		input.nextLine();
		
		for (int i = 0; i < testCase; i++) {
			singer = input.nextLine();
			fan = input.nextLine();	
			
			System.out.println(hug(singer, fan));
		}
		
	}
}

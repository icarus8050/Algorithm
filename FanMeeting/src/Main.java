import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int hug(String singer, String fan){
		ArrayList<Integer> singerList = new ArrayList<Integer>();
		ArrayList<Integer> fanList = new ArrayList<Integer>();
		
		for (int i = 0; i < singer.length(); i++) {
			if (singer.charAt(i) == 'M')
				singerList.add(1);
			else
				singerList.add(0);
		}
		for (int i = 0; i < fan.length(); i++) {
			if (fan.charAt(i) == 'M')
				fanList.add(0, 1);
			else
				fanList.add(0, 0);
		}
		
		int count = 0;
		ArrayList<Integer> result = karatsuba(singerList, fanList);
		for (int i = singerList.size() - 1; i < fanList.size(); i++) {
			if (result.get(i) == 0) count++;
		}
		
		return count;
	}
	
	public static ArrayList<Integer> karatsuba(
			ArrayList<Integer> a, ArrayList<Integer> b){
		if (a.size() < b.size()) return karatsuba(b, a);
		if (a.size() == 0 || b.size() == 0) return new ArrayList<Integer>();
		if (a.size() < 50)
			return multiply(a, b);
		
		int half = a.size() / 2;
		ArrayList<Integer> a0 = new ArrayList<Integer>(a.subList(0, half));
		ArrayList<Integer> a1 = new ArrayList<Integer>(a.subList(half, a.size()));
		ArrayList<Integer> b0 = new ArrayList<Integer>(b.subList(0, Math.min(b.size(), half)));
		ArrayList<Integer> b1 = new ArrayList<Integer>(b.subList(Math.min(b.size(), half), b.size()));
		
		ArrayList<Integer> z2 = karatsuba(a1, b1);
		ArrayList<Integer> z0 = karatsuba(a0, b0);
		a0 = addTo(a0, a1, 0);
		b0 = addTo(b0, b1, 0);
		ArrayList<Integer> z1 = karatsuba(a0, b0);
		z1 = subFrom(z1, z0);
		z1 = subFrom(z1, z2);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		result = addTo(result, z0, 0);
		result = addTo(result, z1, half);
		result = addTo(result, z2, half * 2);
		
		return result;
	}
	
	public static ArrayList<Integer> nomalize(ArrayList<Integer> num){
		//num.add(0);
		
		for (int i = 0; i < num.size() - 1; i++) {
			if(num.get(i) < 0) {
				int borrow = (Math.abs(num.get(i)) + 9) / 10;
				num.set(i + 1, num.get(i + 1) - borrow);
				num.set(i, num.get(i) + borrow * 10);
			}
			else {
				num.set(i + 1, num.get(i + 1) + num.get(i) / 10);
				num.set(i, num.get(i) % 10);
			}
		}
		while(num.size() > 1 && num.get(num.size() - 1) == 0)
			num.remove(num.size() - 1);
		System.out.println(num.get(num.size() - 1));
		return num;
	}
	
	public static ArrayList<Integer> multiply(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < a.size() + b.size(); i++) 
			result.add(0);
		
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < b.size(); j++) {
				result.set(i + j, result.get(i + j) + a.get(i) * b.get(j));
			}
		}
		
		//result = nomalize(result);
		return result;
	}
	
	public static ArrayList<Integer> addTo(ArrayList<Integer> a, ArrayList<Integer> b, int k){
		for (int i = 0; i < Math.max(a.size(), b.size() + k); i++) {
			a.add(0);
		}
		
		for (int i = 0; i < b.size(); i++) 
			a.set(i + k, a.get(i + k) + b.get(i));
		
		//a = nomalize(a);
		
		return a;
	}
	
	public static ArrayList<Integer>subFrom(ArrayList<Integer> a, ArrayList<Integer> b){
		for(int i = 0; i < b.size(); i++) {
			a.set(i, a.get(i) - b.get(i));
		}
		//a = nomalize(a);
		
		return a;
	}
	
	public static void main(String[] args) {
		int testCase;
		String singer = null;
		String fan = null;
		
		Scanner input = new Scanner(System.in);
		testCase = input.nextInt();
		input.nextLine();
		if (testCase > 20) System.exit(0);
		
		for (int i = 0; i < testCase; i++) {
			singer = input.nextLine();
			fan = input.nextLine();	
			if(singer.length() > 20000 || singer.length() < 1 || fan.length() > 20000 || fan.length() < 1 || singer.length() > fan.length())
				System.exit(0);
			
			System.out.println(hug(singer, fan));
		}
		
	}
}

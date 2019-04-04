
public class RandomNumberMaker {

	public static int[] getNumber() {
		int[] randomNumber = new int[100];
		
		for (int i = 0; i < randomNumber.length; i++) {
			randomNumber[i] = (int) (Math.random() * 1000);
		}
		
		return randomNumber;
	}
}


public class MergeSort {

	public static void main(String[] args) {
		int[] arr = RandomNumberMaker.getNumber();
		
		Util.printArray(arr);
		System.out.println("------------------------------------------------------");
		MergeSort.sort(arr, 0, arr.length - 1);
		Util.printArray(arr);
	}
	
	public static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			mergeTwoArea(arr, left, mid, right);
		}
	}
	
	private static void mergeTwoArea(int[] arr, int left, int mid, int right) {
		int leftIdx = left;
		int rightIdx = mid + 1;
		
		int[] temp = new int[right - left + 1];
		int tempIdx = 0;
		while (leftIdx <= mid && rightIdx <= right) {
			if (arr[leftIdx] > arr[rightIdx]) {
				temp[tempIdx++] = arr[rightIdx++];
			} else {
				temp[tempIdx++] = arr[leftIdx++];
			}
		}
		
		while (leftIdx <= mid)
			temp[tempIdx++] = arr[leftIdx++];
		
		while (rightIdx <= right)
			temp[tempIdx++] = arr[rightIdx++];
		
		tempIdx = 0;
		for (int i = left; i <= right; i++) {
			arr[i] = temp[tempIdx++];
		}
	}
}

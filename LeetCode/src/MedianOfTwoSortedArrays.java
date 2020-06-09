/**
 * Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays/)
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n + m];
        int k = 0;
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i++];
            } else {
                arr[k] = nums2[j++];
            }

            k++;
        }

        while (i < n) {
            arr[k++] = nums1[i++];
        }

        while (j < m) {
            arr[k++] = nums2[j++];
        }

        int length = n + m;
        if (length % 2 == 0) {
            return (double) (arr[length / 2] + arr[length / 2 - 1]) / 2;
        } else {
            return arr[length / 2];
        }
    }
}

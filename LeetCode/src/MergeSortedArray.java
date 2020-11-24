/**
 * 88. Merge Sorted Array (https://leetcode.com/problems/merge-sorted-array/)
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        if (m >= 0) System.arraycopy(nums1, 0, temp, 0, m);

        int idx1 = 0;
        int idx2 = 0;
        int i = 0;

        while (idx1 < m && idx2 < n) {
            if (temp[idx1] < nums2[idx2]) {
                nums1[i++] = temp[idx1++];
            } else {
                nums1[i++] = nums2[idx2++];
            }
        }

        while (idx1 < m) {
            nums1[i++] = temp[idx1++];
        }

        while (idx2 < n) {
            nums1[i++] = nums2[idx2++];
        }
    }
}

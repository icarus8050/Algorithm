/**
 * 11. Container With Most Water (https://leetcode.com/problems/container-with-most-water/)
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0;

        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return area;
    }
}

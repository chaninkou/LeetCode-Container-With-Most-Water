package leetcode11;

public class FindContainerWithMostWaterFunction {
	// O(n^2) solution, brute force, can do better
	public int maxAreaBrute(int[] height) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {

				int min = Math.min(height[i], height[j]);
				max = Math.max(max, min * (j - i));
			}
		}
		return max;
	}

	// O(n) solution, using two pointers from left and right
	// O(n) because no matter what, we are decreasing i and j which is total of
	// n
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;

		// Setting the max number with the smallest number first
		int max = Integer.MIN_VALUE;

		// Left pointer and right pointer until both pointer at the same index
		while (left < right) {
			// Since the containter can only contain the smaller height
			int min = Math.min(height[left], height[right]);

			// j - i because to get the distance they are apart from
			max = Math.max(max, min * (right - left));

			// Move the smaller height pointer inward
			if (height[left] < height[right]) {
				left++;
			} else { // when height[i] > height[j]
				right--;
			}
		}

		return max;
	}

	public int maxArea1(int[] height) {
		int left = 0;

		int right = height.length - 1;

		int max = Integer.MIN_VALUE;

		// Two pointers
		while (left < right) {
			// Only get the sum water of the min
			if (height[left] < height[right]) {
				max = Math.max(max, height[left] * (right - left));

				left++;
			} else {
				max = Math.max(max, height[right] * (right - left));

				right--;
			}
		}

		return max;
	}
}

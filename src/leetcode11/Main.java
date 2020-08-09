package leetcode11;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		System.out.println("Height: " + Arrays.toString(height));
		
		FindContainerWithMostWaterFunction solution = new FindContainerWithMostWaterFunction();
		
		System.out.println("Container with most water: " + solution.maxArea(height));
	}
}

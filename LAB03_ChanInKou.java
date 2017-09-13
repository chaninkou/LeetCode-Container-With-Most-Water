package lab3;

public class LAB03_ChanInKou {

	public static void main(String[] args) 
	{
//		int[] array = {0, 13, -25, 20, -3, -16, -23, 18, 20, 22,-7, 12, -5, -22, 15, -4, 7};
		int[] array = {1, 3, 2, 10, -2};
		bruteFroceFindMax(array);
		
		System.out.println(findMaxSubarray(array, 0, array.length-1, 0));
	}
	
	public static void bruteFroceFindMax(int[] array){
		int buy = 0;
		int sell = 0;
		int sum = 0;
		int maxArray = 0;
		int lowestArray = 0;
		
		for (buy = 0; buy < array.length; buy++){
			int tempSum = 0;
			for(sell = buy; sell < array.length; sell++){		
				tempSum = tempSum + array[sell];
				if (tempSum > sum){
					sum = tempSum;
					lowestArray = array[buy];
					maxArray = array[sell];
				}
			}
		}
		System.out.println("With brute force, the Maximum subarray is " + lowestArray + " to " + maxArray + " and the sum is " + sum);
	}
	
	public static int findMaxSubarray(int[] array, int low, int high,int sum) {
		if(high == low){
			return array[low];
		}
		else{
			int mid = (low+high)/2;
			int leftSum = findMaxSubarray(array, low, mid, sum);
			int rightSum = findMaxSubarray(array, mid+1, high, sum);
			int crossSum = MaxCross(array, low,mid, high, sum);
			if(leftSum >= rightSum & leftSum>= crossSum){
				return leftSum;
			}
			else if(rightSum >= leftSum & rightSum>= crossSum){
				return rightSum;
			}
			else{
				return crossSum;
			}	
		}
	}
	
	public static int MaxCross(int[] array, int low, int mid, int high, int totalsum){
		int leftSum = 0;
		int sum = 0;
		int maxLeft;
		int maxRight;
		for(int i = mid; i < mid; i++){
			sum = sum + array[i];
			if(sum >leftSum){
				leftSum = sum;
				maxLeft = i;
			}
		}
		int rightSum = 0;
		int sum1 = 0;
		for(int j = mid+1; j < high; j++){
			sum1 = sum1 + array[j];
			if(sum1 > rightSum){
				rightSum = sum1;
				maxRight = j;
			}
		}
		totalsum = leftSum + rightSum;
		return totalsum;
	}
	
	class MaxSubarray{
		int low;
		int high;
		int sum;
		
		public MaxSubarray(int low, int high, int sum){
			this.low = high;
			this.high = high;
			this.sum = sum;
		}
		
	}
	
}
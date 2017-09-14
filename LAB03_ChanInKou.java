package lab3;

public class LAB03_ChanInKou {

	public static void main(String[] args) 
	{
		int[] array = {0, 13, -25, 20, -3, -16, -23, 18, 20,-7, 12, -5, -22, 15, -4, 7};

		bruteFroceFindMax(array);
		int[] answer = findMaxSubarray(array, 0, array.length-1, 0);
		System.out.println("With divide and conquer, the maximum subarray is index " +answer[0] + " to index " + answer[1] + " with the sum of " + answer[2]);
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
					lowestArray = buy;
					maxArray = sell;
				}
			}
		}
		System.out.println("With brute force, the Maximum subarray is index " + lowestArray + " to index " + maxArray + " and the sum is " + sum);
	}
	
	public static int[] findMaxSubarray(int[] array, int low, int high,int sum) {
		if(high == low){
			int[] temp = {low, high, array[low]};
			return temp;
		}
		else{
			int mid = (low+high)/2;
			int[] leftSum =  findMaxSubarray(array, low, mid, sum);
			int[] rightSum = findMaxSubarray(array, mid+1, high, sum);
			int[] crossSum = MaxCross(array, low, mid, high);
			if(leftSum[2] >= rightSum[2] & leftSum[2]>= crossSum[2]){
				sum = leftSum[2];
			
				return leftSum;
			}
			else if(rightSum[2] >= leftSum[2] & rightSum[2]>= crossSum[2]){
				sum = rightSum[2];
				
				return rightSum;
			}
			else
			{
				sum = crossSum[2];
				return crossSum;
			}	
		}
	}
	
	
	public static int[] MaxCross(int[] array, int low, int mid, int high){
		int leftSum = array[mid];
		int sum = 0;
		int maxLeft = mid;
		int maxRight = mid+1;
		for(int i = mid; i < mid; i--){
			sum = sum + array[i];
			if(sum >leftSum){
				leftSum = sum;
				maxLeft = i;
			}
		}
		int sum1 = 0;
		int rightSum = array[mid+1];
		
		for(int j = mid+1; j < high; j++){
			sum1 = sum1 + array[j];
			if(sum1 > rightSum){
				rightSum = sum1;
				maxRight = j;
			}
		}
		
		int totalsum = leftSum + rightSum;
		int[] result = {maxLeft,maxRight, totalsum}; 
		return result;
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
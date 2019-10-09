package mostWater;

public class FindContainerWithMostWaterFunction {
    // O(n^2) solution, brute force, can do better
//  public int maxArea(int[] height) {
//      int max = Integer.MIN_VALUE;
     
//      for(int i = 0; i < height.length; i++){
//          for(int j = i + 1; j < height.length; j++){
//              int min = Math.min(height[i], height[j]);
             
//              max = Math.max(max, min * (j - i));
//          }
//      }
         
//      return max;
//  }
         
 // O(n) solution, using two pointers from left and right
 public int maxArea(int[] height){
     // Left pointer at 0 and right pointer at the last index
     int i = 0;
     int j = height.length - 1;
     
     // Setting the max number with the smallest number first
     int max = Integer.MIN_VALUE;
     
     // Left pointer and right pointer until both pointer at the same index
     while(i < j){
         // Since the containter can only contain the smaller height
         int min = Math.min(height[i], height[j]);
         
         // j - i because to get the distance they are apart from
         max = Math.max(max, min * (j - i));
         
         // Move the smaller height pointer inward
         if(height[i] < height[j]){
             i++;
         } else { // when height[i] > height[j]
             j--;
         }
     }
     
     return max;
 }
}

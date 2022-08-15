/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray
[numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */

class MinSumSubArray {
    public static void main(String[] args) {
        //target = 7, nums = [2,3,1,2,4,3]
        int[] nums = new int[]{2,3,1,2,4,3};
    }
    public int minSubArrayLen(int target, int[] nums) {

        int minLen = Integer.MAX_VALUE;
        int startWindow = 0;
        int sum = 0;
        for(int endWindow = 0; endWindow < nums.length; endWindow++) {
            sum += nums[endWindow];
            while(sum >= target) {
                minLen = Math.min(minLen, endWindow - startWindow + 1);
                sum -= nums[startWindow];
                startWindow++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}

//Solution is O(n). Using two pointers and a dynamically changing sliding window, we can traverse the array in one swipe
//Start off with initilizaing minLen representing the minimum length to get the sum. Next we need two pointers since
//the size of the window is dynamic so we must change the starting point of the window when sum >= target.
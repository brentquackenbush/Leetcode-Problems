//Given an array of integers nums, calculate the pivot index of this array.
//
// The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the
// sum of all the numbers strictly to the index's right.
//
// If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
// This also applies to the right edge of the array.
//
//  Return the leftmost pivot index. If no such index exists, return -1.

public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {0,5,7,1,5,7};
        int ans = pivotIndex(nums);
        System.out.println(ans);
    }

    public static int pivotIndex(int[] nums) {

        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}

//SOLUTION: This has a time complexity of O(2n) or O(n) because it iterates through the array twice. One round to go through array
//to sum up the value. Then it goes through the array again to find the pivot index using the sum as a helper to help find the pivot
//index by subtracting the leftsum and nums[i] to see if both sides equal to eachother.
//Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//
//        [4,5,6,7,0,1,2] if it was rotated 4 times.
//        [0,1,2,4,5,6,7] if it was rotated 7 times.
//        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
//        Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//
//        You must write an algorithm that runs in O(log n) time.

public class FindMinInRotatedSorted {

    public static void main(String[] args) {
        int[] test1 = {0,1,2,3,4,5};//min 0   0 is at beginning
        int[] test2 = {6,7,8,1,2,3}; //min 1 min is on the right side
        int[] test3 = {9,0,1,3,4,5}; //min 0 min is on the left side
        int[] test4 = {2,1};
        System.out.println(findMin(test1));
        System.out.println(findMin(test2));
        System.out.println(findMin(test3));
        System.out.println(findMin(test4));
    }

    public static int findMin(int[] nums) {

        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length-1;
        while( left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}

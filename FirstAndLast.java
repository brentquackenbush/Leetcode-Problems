//Given an array of integers nums sorted in non-decreasing order,
// find the starting and ending position of a given target value.
//
// If target is not found in the array, return [-1, -1].
//
// You must write an algorithm with O(log n) runtime complexity.
//
import java.util.ArrayList;

public class FirstAndLast {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,6,7,9,9,10};
        int[] ans = searchRange(nums,9);

        for(int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int[] ans = {-1,-1};
        ans[0] = findFirstStartPos(nums,target);
        ans[1] = findFirstEndPos(nums, target);

        return ans;

    }

    public static int findFirstStartPos(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;
        int start = -1;

        while(left <= right) {
            int mid = left+(right-left)/2;
            if(num[mid] == target) {
                start = mid;
                right = mid - 1; //See if the are any more possibilities on the left hand side of arr.
            }
            else if (num[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return start;
    }

    public static int findFirstEndPos(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;
        int end = -1;

        while(left <= right) {
            int mid = left+(right-left)/2;
            if(num[mid] == target) {
                end = mid;
                left = mid + 1; //See if there are any more possibilities on the right hand side of arr.
            }
            else if (num[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return end;

    }


}

//Solution:
//Based off of the question....It seems like there are only ever two, one, or zero indexs with the target value
//So we can either return two indexs of the target value in the array, one index and -1, or both -1 for indexs.
//First we find the start position of the answer by doing mid - 1
//Second we find the end position of the answer by doing mid + 1
//The reason we for the first we do mid -1 is because when we find the middle of the array it is  left + (right - left)
//


//TIME COMPLEXITY: O(logN) because there is a Binary search that is being implemented in order to find the starting and ending position of
//a target value.

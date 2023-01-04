import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1}; //9
        int[] nums2 = {100,4,200,1,3,2}; //4
    }

    private static int longestConsecutive(int[] nums) {
        if(nums.length < 1) return 0;

        Set<Integer> set = new HashSet<>();
        int max = 1;

        for(int num: nums)
            set.add(num);

        for(int i = 0; i < nums.length; i++) {
            int count = 1;
            int num = nums[i];
            while(set.contains(++num)) {
                count++;
                set.remove(num);
            }

            num = nums[i];
            while(set.contains(--num)) {
                count++;
                set.remove(num);
            }
            max = Math.max(max, count);
        }

        return max;
    }
}

/*
Solution: This takes O(n) because the set methods .remove and .contains are O(1) and we are iterating through the entire
array once, therefore it takes O(n) time. We look from the left and the from the right of num to find the longest consecutive
sequence. Space complexity is O(n).
 */

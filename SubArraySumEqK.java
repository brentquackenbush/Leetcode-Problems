import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums,2));
    }
    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}

/*
Time complexity is O(n)
Space complexity is O(n)

Prefix sum is the sum of current number + it's previous sums.
We use that to be able to traverse the array in one pass while finding subarrays that sum are equal to k.
 */

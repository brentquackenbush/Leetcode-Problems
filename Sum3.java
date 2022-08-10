import java.util.*;

public class Sum3 {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i + 2 < nums.length; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                    continue;
                }
                int j = i + 1, k = nums.length - 1;
                int target = -nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                        while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                    } else if (nums[j] + nums[k] > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
            return res;
        }
    }

//Rules. You can't use a number at the same index more than once.
//The sum of the array has to equal 0.
//This solution is way faster than using a data structure like a hashset to store it.
//Solution: This takes O(n^2) time. We sort the array which takes O(nlogn) time and then we search through the array of n length n amount of times until we reach
//end of array.



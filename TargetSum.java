public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    //    public static int findTargetSumWays(int[] nums, int S) {
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if(S > sum || (sum + S) % 2 == 1)   return 0;
//        return subsetSum(nums, (sum + S) / 2);
//    }
//
//    private static int subsetSum(int[] nums, int S){
//        if(S < 0) return 0;
//        int[] dp = new int[S + 1];
//        dp[0] = 1;
//        for (int num: nums) {
//            for (int j = S; j >= num; j--) {
//                dp[j] += dp[j - num];
//            }
//        }
//        return dp[S];
//    }
    public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;

        for (int i : nums) sum += i;
        if (s > sum || s < -sum) return 0;

        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;

        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * sum + 1];
            for (int k = 0; k < 2 * sum + 1; k++) {
                if (dp[k] != 0) {
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum + s];
    }

}

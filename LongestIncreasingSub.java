public class LongestIncreasingSub {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,11,12,13,8,9};
        //[4,5,11,12,13] is of length 5 which is the LIS
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}

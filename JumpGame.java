public class JumpGame {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        int[] nums2 = new int[]{3,2,1,0,4};

        int[] nums3 = new int[]{10,0,0,0,1,0};
        System.out.println(canJump(nums3));
    }

    public static boolean canJump(int[] nums) {
        if(nums.length < 2) return true;

        for(int curr = nums.length-2; curr>=0;curr--){
            if(nums[curr] == 0){
                int neededJumps = 1;
                while(neededJumps > nums[curr]){
                    neededJumps++;
                    curr--;
                    if(curr < 0) return false;
                }
            }
        }
        return true;
    }
}
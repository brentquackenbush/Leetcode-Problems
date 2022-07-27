//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//        Note that you must do this in-place without making a copy of the array.

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0,1,0,0,12,3,2,0};
        moveZeros(nums);
    }

    public static void moveZeros(int[] nums) {
        if(nums.length <= 1) return;
        //enter snowball effect
        int snowball = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                snowball++;
            } else if(snowball > 0) {
                nums[i - snowball] = nums[i];
                nums[i] = 0;
            }
        }

        //enter snowball effect

    }

}

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

//TIME COMPLEXITY: O(n) I traverse through the entire array of length N only once.
//SOLUTION: The snowball effect. For every 0 that is found, we increment snowball. The next time the for loop iterates over to
//a number > 0, then go back to the position where it last saw a number > 0 and set that number to the current number and set the current location we are at
//to 0. i.e. if we start with array [0,1,1,0,0,5], the alogrithm would solve it in this matter ->
//[1,0,1,0,0,5]
//[1,1,0,0,0,5]
//[1,1,5,0,0,0]
//Given an array, rotate the array to the right by k steps, where k is non-negative.

public class RotateArray {

    public static void main(String[] args) {
        int k = 9;
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        rotate(nums,k);
    }

    //k is the number of steps to rotate the array to the right
//    public static void rotate(int[] nums, int k) {
//        if(nums.length <= 1){
//            return;
//        }
//        //step each time to move
//        int step = k % nums.length;
//        int[] tmp = new int[step];
//        //tmp grabs the numbers that are going past the array length and back into the beginning of the array
//        for(int i = 0; i < step; i++){
//            tmp[i] = nums[nums.length - step + i];
//        }
//        for(int i = nums.length - 1 - step; i >= 0; i--){
//            nums[i + step] = nums[i];
//        }
//        for(int i = 0; i < step; i++){
//            nums[i] = tmp[i];
//        }
//
//
//    }
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1); //we have to first reverse the whole array by swapping first element with the last one and so on..
        reverse(nums, 0, k - 1); //reverse the elements from 0 to k-1
        reverse(nums, k, nums.length - 1); //reverse the elements from k to n-1
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}

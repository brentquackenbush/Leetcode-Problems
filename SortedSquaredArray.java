//Given an integer array nums sorted in non-decreasing order,
//        return an array of the squares of each number sorted in non-decreasing order.

public class SortedSquaredArray {

    public static void main(String[] args) {
        int[] arr = {-19,-6,0,1,4,22};
        arr = sortAndSquareArray(arr);
        for(int i: arr) {
            System.out.println(i);
        }
    }

    public static int[] sortAndSquareArray(int[] nums) {
        int[] newSquaredArray = new int[nums.length];
        int i = 0;
        int j = nums.length-1;
        int index = nums.length-1;

        while(i <= j) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                newSquaredArray[index] = nums[i] * nums[i];
                i++;
            } else {
                newSquaredArray[index] = nums[j] * nums[j];
                j--;
            }
            index--;
        }
        return newSquaredArray;
    }

}

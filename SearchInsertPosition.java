public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] ex1 = {1,2,3,4,5}; int target1 = 3; //target is in array
        int[] ex2 = {2,3,4,5}; int target2= 1; //target is not in array and smaller than first number in arr
        int[] ex3 = {4,5,6,9,10,11}; int target3= 7; //target is not in array and needs to be pushed between numbers
        int[] ex4 = {6,7,8,9}; int target4 = 10; //target is not in array and needs to be added to back of arr

        int ans1 = searchInsert(ex1,target1); //2
        int ans2= searchInsert(ex2,target2); //0
        int ans3 = searchInsert(ex3,target3); //3
        int ans4= searchInsert(ex4,target4); //4
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        if (nums[nums.length - 1] < target) return nums.length;
        if (nums[0] > target) return 0;

        while (left <= right) {

            mid = left + (right - left) / 2; //I do this because I don't want to cause an overflow so instead of adding right to left and dividing to find middle. I subtract right from left and then add left.

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) { //if target is less than the middle. Set
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }


            if (left > right) {
                return mid;
            }
        }

        return -1; //if there array is empty return -
    }
}


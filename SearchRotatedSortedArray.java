public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] ans = {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(ans,target));
        System.out.println(search(ans,2));

    }
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){ //if value at mid is bigger than the value at the start of array
                if (target < nums[mid] && target >= nums[start]) //if target is less than value at mid and target is bigger than value at start
                    end = mid - 1; //value must be on the left side array
                else
                    start = mid + 1; //vaue must be on the right side of array
            }

            if (nums[mid] <= nums[end]){ //if value at mid is less than or equal to number at end
                if (target > nums[mid] && target <= nums[end]) //if target is bigger than mid and target is less than the number at end
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}

//Solution: Since this is rotated k positions it can't be searched using a binary search right away. There are some boundaries
//we need to check.

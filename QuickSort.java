public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6,4,1,2,3,10,9,8,7,5};
        quicksort(arr);
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
    public static void quicksort(int[] nums) {
        quicksort(nums,0,nums.length-1);
    }
    public static void quicksort(int[] nums, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex) return;

        int pivot = nums[highIndex];

        int leftPointer = partition(nums,lowIndex,highIndex,pivot);

        quicksort(nums,lowIndex, leftPointer -1);
        quicksort(nums,leftPointer+1,highIndex);
    }

    public static int partition(int[] nums, int lowIndex, int highIndex, int pivot) {

        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while(leftPointer < rightPointer) {

            while(nums[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while(nums[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(nums,leftPointer,rightPointer);
        }
        if(nums[leftPointer] > nums[highIndex]) {
            swap(nums, leftPointer, highIndex);
        }
        else {
            leftPointer = highIndex;
        }
        return leftPointer;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//Quicksort takes a int low index and int high index and a pivot
//does a while loop to make sure left < right at all times
//increment left if left <= pivot && left < right
//decrement right if right >= pivot && left < right
//swap(
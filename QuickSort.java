public class QuickSort {
    public static void main(String[] args) {
        int[] quickSort = new int[]{120,2,4501,46,12,1000};
        quicksort(quickSort,0,quickSort.length-1);
        for(int num: quickSort) {
            System.out.print(num + " ");
        }
    }

    public static void quicksort(int[] arr, int lowIndex, int highIndex) {

        if(lowIndex >= highIndex) return;

        int pivot = arr[highIndex];

        int left = lowIndex;
        int right = highIndex;
        while(left < right) {
            while(arr[left] <= pivot && left < right) left++;
            while(arr[right] >= pivot && left < right) right--;

            swap(arr,left,right);
        }
        swap(arr,left,highIndex);

        quicksort(arr,lowIndex,left-1);
        quicksort(arr,left + 1, highIndex);
    }

    private static void swap(int[] arr, int lowIndex, int highIndex) {
        int temp = arr[lowIndex];
        arr[lowIndex] = arr[highIndex];
        arr[highIndex] = temp;
    }
}

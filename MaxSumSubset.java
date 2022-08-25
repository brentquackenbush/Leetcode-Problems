public class MaxSumSubset {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,5,10,-11,2,2,2,-20}; //answer should be 17
        System.out.println(kadanesAlgorithm(arr));

        int[] arr1 = new int[]{-1,-2,-5,-10,-11,-2,-2,-2,-20}; //answer should be -1
        System.out.println(kadanesAlgorithm(arr1));
    }
    public static int kadanesAlgorithm(int[] arr) {
        if(arr.length == 1) return arr[0];
        int currN = 0;
        int currMax = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            currN += arr[i];
            if(currN > currMax) currMax = currN;
            if(currN < 0) currN = 0;
        }
        return currMax;
    }
}

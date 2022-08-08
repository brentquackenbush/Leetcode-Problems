public class Search2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int target = 6;
        System.out.println("The matrix has the target in it " + searchMatrix(matrix,target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length-1;
        int col = matrix[0].length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(matrix[mid][0] <= target && matrix[mid][col] >= target) {
                return searchRow(matrix[mid],target);
            } else if(matrix[mid][0] < target) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return false;
    }

    public static boolean searchRow(int[]row,int target) {
        int start = 0;
        int end = row.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(row[mid] == target) {
                return true;
            } else if(row[mid] < target) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return false;
    }
}
//Solution: O(log(m*n)) m = number of rows and n = number of columns. For this solution I came up with
//checking the first int in the row and seeing if it was less than the target if it was then check if the last
//int in that row is less than target. If it is check that row and do a binary search on it to find the target
//if it isn't there than return false. Easy as that.

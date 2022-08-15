/*
goes from all the way right. all the way down. all the way left. All the way up. And so on.
Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.ArrayList;
import java.util.List;
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = spiralMatrix(input);
        for(Integer i: list) {
            System.out.print(i + " ");
        }

    }
    public static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0 || matrix == null) return list;
        int startRow= 0, endRow = matrix.length -1;
        int startCol = 0, endCol = matrix[0].length -1 ;
        int dir = 0;
        while(startRow <= endRow && startCol <= endCol) {
            switch(dir) {
                case 0: //RIGHT
                    for(int col = startCol; col <= endCol; col++) {
                        list.add(matrix[startCol][col]);
                    }
                    startRow++;
                    break;
                case 1: //DOWN
                    for(int row = startRow; row <= endRow; row++) {
                        list.add(matrix[row][endCol]);
                    }
                    endCol--;
                    break;
                case 2: //LEFT
                    for(int col = endCol; col >= startCol; col--) {
                        list.add(matrix[endRow][col]);
                    }
                    endRow--;
                    break;
                case 3: //UP
                    for(int row = endRow; row >= startRow; row--) {
                        list.add(matrix[row][startCol]);
                    }
                    startCol++;
                    break;
            }
            dir = (dir+1)%4;
        }
        return list;

    }
}

//Solution: O(m*n) m = number of rows n = number of columns. To return a spirtal matrix we need to go from right to
//down to left to up and boom there we go. We need 4 dynamic variables that will reflect the start of the row, end of the row
//start of the column and end of the column. These need to be dynamic because we will be incrementing and decrementing them
//based off of what how deep we are traversing this matrix.

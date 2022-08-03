//You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
// You may assume all four edges of the grid are surrounded by water.
//
//        The area of an island is the number of cells with a value 1 in the island.
//
//        Return the maximum area of an island in grid. If there is no island, return 0.
//

import jdk.jfr.DataAmount;

//Iterative and RecursiveApproach
public class MaxAreaOfIsland {

    public static void main(String[] args) {

    }

    public int maxAreaOfIslandResursive(int[][] grid) {
        int max = 0; //Keep track of the maximum area of the island
        for(int i = 0; i < grid.length; i ++) { //Iterate grid top and bottom
            for(int j = 0; j < grid[0].length; j++) //Iterate length and right
                if(grid[i][j] == 1) {//meets an island {
                    max = Math.max(max, dfs(grid,i,j)); //if the current island is larger than the island found before, set max to new island area
                }
        }

        return max;
    }

    public int dfs(int[][]grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0; //set current location to 0 so we don't comeback to this island. Sink algorithm
        //now we visit every point of island
        int count = 1; //this is set to 1 already because we have found the first point of the island
        count += dfs(grid,i+1,j);
        count += dfs(grid,i-1,j);
        count += dfs(grid,i,j+1);
        count += dfs(grid,i,j-1);

        return 0;
    }

}

//Solution Recursive: Using the Sink method, by setting the value of the coordinate we are currently at to 0, this will
// make sure we don't come back to that same point and go in circles. We iterate through every point of the sea (the grid)
// If we encounter an island i.e. grid[i][j] == 1 we now call DFS algorithm to search every point of the island and
// calculate its area. Time complexity of O(i * j) where i is number of rows and j = number of columns.

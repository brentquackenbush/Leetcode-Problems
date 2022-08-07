//You are given an m x n grid where each cell can have one of three values:
//
//        0 representing an empty cell,
//        1 representing a fresh orange, or
//        2 representing a rotten orange.
//        Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//        Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

    public static void main(String[] args) {
        //answer should be 3
        int[][]rottenGarden =
                {{0,1,0,0},
                 {0,1,1,0},
                 {0,0,2,0}
        };
        //answer should be 0
        int[][]nonRottenGarden = {{1,0,0,1},
                                 {0,0,2,0},
                                 {1,0,0,0}};

        //answer should be -1
        int[][] rottenButOrangeLeftGarden = {{0,0,0,0},
                                            {0,0,2,0},
                                            {0,0,0,0}};

        System.out.println("Answer to this should be 3: " + orangesRottin(rottenGarden));
        System.out.println("Answer to this should be -1: " + orangesRottin(nonRottenGarden));
        System.out.println("Answer to this should be 0: " + orangesRottin(rottenButOrangeLeftGarden));
    }

    //BFS implementation
    public static int orangesRottin(int[][]grid) {
        if(grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int column = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int goodOranges = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                if(grid[i][j] == 1) goodOranges++;
            }
        }

        int count = 0;
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        if(goodOranges == 0) return 0;
        //after I entered all the rotten tomatoes into the queue I need to find its neighbors. We start off by
        //incrementing count stating that at this level there is a rotten tomato, and we need to turn its neighbors into rotten
        //tomatoes. Add that new rotten tomato into the queue, and then find its neighbors and continue down the line.
        // How do I find out if there is a 1 strangling on it's end and need to return -1 because it can't be turned
        // into a rotten tomato?
        while(!q.isEmpty()) {
            ++count;
            int size = q.size();
            for(int i =0; i < size; i++) {
                int[] rotten = q.poll();
                //Go through every neighbor possible
                for(int[] dir: dirs) {
                    int nx = dir[0] + rotten[0];
                    int ny = dir[1] + rotten[1];

                    if(nx < 0 || ny < 0 || nx >= row || ny >= column || grid[nx][ny] != 1 ) continue;
                    //check to see if the neighbor is a healthy orange if it is, add to queue and make it rotten

                        grid[nx][ny] = 2;
                        q.offer(new int[]{nx,ny});


                }
            }

        }
        for (int[] x : grid) {
            for (int y : x) {
                if (y == 1)
                    return -1;
            }
        }
        return count -1;
    }
}

//SOLUTION: We know that if there is a rotten orange, the next neighbors will also be turned into neighbors and the
// closest neighbors will add a minute to how long it takes to rot the garden. By this we know that we will have to traverse
//through potentially the whole garden. Through my solution the time complexity is O(m*n*2) as we traverse the garden twice
//one to find all the rotten tomatoes and the next to turn all the tomatoes into rot.

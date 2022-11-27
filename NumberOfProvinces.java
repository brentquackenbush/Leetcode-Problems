//Basically another question could be find circle of friends.
/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is
connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
    public static int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length]; //visited[i] means if ith person is visited in this algorithm
        int count = 0;
        for(int i = 0; i < M.length; i++) {
            if(!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private static void dfs(int[][] M, boolean[] visited, int person) {
        for(int other = 0; other < M.length; other++) {
            if(person == other) continue;
            if(M[person][other] == 1 && !visited[other]) {
                //We found an unvisited person in the current friend cycle
                visited[other] = true;
                dfs(M, visited, other); //Start DFS on this new found person
            }
        }
    }

    public static int findCircleNumBFS(int[][] isConnected) {
        int cities = isConnected.length;
        int provinces = 0;

        boolean[] visited = new boolean[cities];
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < cities; i++)
        {
            if(!visited[i])
            {
                q.offer(i);
                provinces++;
            }
            while(!q.isEmpty())
            {
                int current = q.poll();
                visited[current] = true;
                for(int j = 0; j < cities; j++)
                {
                    if(j != current && isConnected[current][j] == 1 && !visited[j])
                        q.offer(j);
                }
            }
        }

        return provinces;
    }

}

/*
We can do this in a DFS and BFS manner. Here I implemented a DFS search that will take O(n^2) since the matrix is n*n and we
need to go through the entire thing
The space complexity is O(n) because I kept track of the visits we have done.
 */
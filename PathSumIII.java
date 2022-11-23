/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
Constraints:

The number of nodes in the tree is in the range [0, 1000].
-10^9 <= Node.val <= 10^9
-1000 <= targetSum <= 1000
 */
// https://leetcode.com/problems/path-sum-iii/
import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.left.left = new TreeNode(3);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        //[10,5,-3,3,2,null,11,3,-2,null,1]
        //targetSum = 8. Output should be 3
        System.out.println(countPaths(root,8));
    }
    static private Map<Long,Integer> map;

    public static int pathSum(TreeNode root, int k) {
        map = new HashMap<>();
        map.put(0L,1);
        return dfs(root,k,0);
    }

    public static int dfs(TreeNode node, int k, long curSum) {
        if(node == null) return 0;

        curSum += node.val;
        int res = map.getOrDefault(curSum - k, 0);
        map.put(curSum,map.getOrDefault(curSum,0) + 1);

        res+= dfs(node.left, k, curSum) + dfs(node.right,k,curSum);
        map.put(curSum, map.get(curSum) - 1);
        return res;

    }

    public static int countPaths(TreeNode root, int targetSum) {
        // A map that stores the number of times a prefix sum has occurred so far.
        Map<Integer, Integer> map = new HashMap<>();

        return countPathsPrefixSum(root, targetSum, map, 0);
    }

    public static int countPathsPrefixSum(TreeNode node, int targetSum, Map<Integer, Integer> map, Integer currentPathSum) {
        if (node == null)
            return 0;

        // The number of paths that have the required sum.
        int pathCount = 0;

        // 'currentPathSum' is the prefix sum, i.e., sum of all node values from root to current node.
        currentPathSum += node.val;

        // This is the base case. If the current sum is equal to the target sum, we have found a path from root to
        // the current node having the required sum. Hence, we increment the path count by 1.
        if (targetSum == currentPathSum)
            pathCount++;

        //'currentPathSum' is the path sum from root to the current node. If within this path, there is a
        // valid solution, then there must be an 'oldPathSum' such that:
        // => currentPathSum - oldPathSum = targetSum
        // => currentPathSum - targetSum = oldPathSum
        // Hence, we can search such an 'oldPathSum' in the map from the key 'currentPathSum - targetSum'.
        pathCount += map.getOrDefault(currentPathSum - targetSum, 0);

        // This is the key step in the algorithm. We are storing the number of times the prefix sum
        // `currentPathSum` has occurred so far.
        map.put(currentPathSum, map.getOrDefault(currentPathSum, 0) + 1);

        // Counting the number of paths from the left and right subtrees.
        pathCount += countPathsPrefixSum(node.left, targetSum, map, currentPathSum) + countPathsPrefixSum(node.right, targetSum, map, currentPathSum);

        // Removing the current path sum from the map for backtracking.
        // 'currentPathSum' is the prefix sum up to the current node. When we go back (i.e., backtrack), then
        // the current node is no more a part of the path, hence, we should remove its prefix sum from the map.
        map.put(currentPathSum, map.getOrDefault(currentPathSum, 1) - 1);

        return pathCount;
    }
}
/*
Solution:
Time complexity: O(n)
Space complexity: O(n) hashmap
Algorithm prefix sum.

 */

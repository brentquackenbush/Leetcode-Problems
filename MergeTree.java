//You are given two binary trees root1 and root2.
//
//        Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
//
//        Return the merged tree.
//
//        Note: The merging process must start from the root nodes of both trees.

public class MergeTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        for(int i =2; i < 10; i ++) {
            root1.left = new TreeNode(i);
            root1.right = new TreeNode(i+1);
        }
        TreeNode root2 = new TreeNode(1);
        for(int i =2; i < 10; i ++) {
            root2.left = new TreeNode(i);
            root2.right = new TreeNode(i+1);
        }
        TreeNode newTree = mergeTrees(root1,root2);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1 == null) return root2;
        if(root2 == null) return root1;


        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees(root1.left,root2.left);
        newNode.right = mergeTrees(root1.right,root2.right);
        return newNode;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode() {}


    }

}

//Solution: Use a recursive algorithm so sum the left node of both trees into one node and the sum of right trees into right node
//which will allow us to sum up every node. Our base case is if root1 == null return root 2 and do the same for root 2.
//This will take O(2n) which is O(n). It is 2n because it has a left and right child.

//Medium Question
//Leetcode question: Flatten Binary Tree to LinkedList

public class FlattenBSTToLL {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        flatten(root);
        while(root!=null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public static void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode runner = curr.left;
                while (runner.right != null) runner = runner.right;
                runner.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/*

Morris Traversal (O(1) Space, O(N) Time) Approach:

There is actually a way to traverse a binary tree with a space complexity of O(1) while staying at a time complexity of O(N), though it does
require modifying the tree's structure. In this problem that's specifically being called for, so it's a valid approach, though
it won't always be appropriate to modify the source binary tree in other situations.

The approach is called the Morris traversal. At its heart, it takes advantage of the basic nature of ordered traversals to
iterate through and unwind the tree. In a pre-order traversal of a binary tree, each vertex is processed in (node, left, right) order.
This means that the entire left subtree could be placed between the node and its right subtree.

To do this, however, we'll first have to locate the last node in the left subtree. This is easy enough, since we know that the
last node of a pre-order tree can be found by moving right as many times as possible from its root.

So we should be able to move through the binary tree, keeping track of the curent node (curr). Whenever we find a left subtree,
we can dispatch a runner to find its last node, then stitch together both ends of the left subtree into the right path of curr,
taking heed to sever the left connection at curr.

Once that's done, we can continue to move curr to the right, looking for the next left subtree. When curr can no longer move right,
the tree will be successfully flattened.
 */

import java.util.Stack;
public class Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(3),new TreeNode(6));
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        System.out.println(isValidBST(root));

        TreeNode root1 = new TreeNode(5,new TreeNode(4),new TreeNode(6));
        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(2);
        root1.right.right = new TreeNode(9);
        System.out.println(isValidBST(root1));
    }

    public static boolean isValidBSTStack(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
    public static boolean isValidBST(TreeNode root) {
       return helper(root,null,null);
    }
    private static boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val))
            return false;

        return helper(root.left, min, root) && helper(root.right, root, max);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
//what makes a valid BST is the left side values has to be less than parent, right side has to be greater than parent.
//recursive solutioin is much faster than the iterative approach. Recursive is O(n) while the iterative is O(n) still, but the
//iterative approach uses a stack.
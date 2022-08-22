import java.util.Deque;
import java.util.LinkedList;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        preorder(root);
        ///////// TEST DIFFERENT METHODS
        root = invertIteratively(root);
        ////////  TEST DIFFERENT METHODS
        System.out.println();
        preorder(root);
    }

    //BFS
    public static void preorder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static TreeNode invertTreedfs(TreeNode root) {
        if(root == null) return root;
        TreeNode left = root.left, right = root.right;
        root.right = invertTreedfs(left);
        root.left = invertTreedfs(right);
        return root;
    }

    public static TreeNode invertIteratively(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode head = stack.pop();
            TreeNode temp = head.left;
            head.left = head.right;
            head.right = temp;
            if(head.left!=null) {
                stack.push(head.left);
            } else if(head.right!=null){
                stack.push(head.right);
            }
        }
        return root;
    }


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode() {};
        TreeNode(int val) {this.val = val;}
    }

}

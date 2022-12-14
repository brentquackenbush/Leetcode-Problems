//Populating Next Right Pointers in Each Node
//you are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//
//        struct Node {
//        int val;
//        Node *left;
//        Node *right;
//        Node *next;
//        }
import java.util.*;
public class NextRightPointers {

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        //Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.left = node2; root.right = node3;
        node2.left = node4; node2.right = node5;
        //node3.left = node6;
        node3.right = node7;

        //root = connectbfs(root);
        root = connect(root);

    }

    public static Node connect(Node root) {
        Node head = root;
        if(root == null) return root;

        while(head!=null) {
            Node dummy = new Node();
            Node temp = dummy;
            while(head!=null) {
                if(head.left!=null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right!=null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }

        return root;
    }

    public static Node connectbfs(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node rightNode = null;
            for(int i = q.size(); i > 0; i--) {
                Node cur = q.poll();
                cur.next = rightNode;
                rightNode = cur;
                if(cur.right != null) {
                    q.offer(cur.right);
                    q.offer(cur.left);
                }
            }
        }
        return root;
    }
//
    public static Node connectBfstoDfs(Node root) {
        Node head = root;
        for(; root != null; root = root.left)
            for(Node cur = root; cur != null; cur = cur.next)
                if(cur.left != null) {
                    cur.left.next = cur.right;
                    if(cur.next != null) cur.right.next = cur.next.left;
                } else break;

        return head;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

//Solution: So it is important to remember that in order to set the next pointer we must always have a reference
//to the head.The first while loop traverses the entirety of the tree. Second while loop is to make sure all the leafs
//on the current level has its next pointer set to the node on the right.


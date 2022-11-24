import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 */
public class MaximumDepthOfNaryTree {

    public static int maxDepthBFS(Node root) {

        int maxHeight = 0;
        Deque<Node> q = new LinkedList<>();
        if (root == null) return maxHeight;

        q.offer(root);
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                for (Node child : cur.children)
                    q.offer(child);
            }

            maxHeight++;
        }
        return maxHeight;
    }

    public int maxDepthDFS(Node root) {
        if (root == null) return 0;

        int max = 0;

        for (Node child : root.children) {
            int value = maxDepthDFS(child);

            if (value > max)
                max = value;
        }

        return max + 1;
    }


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;


}

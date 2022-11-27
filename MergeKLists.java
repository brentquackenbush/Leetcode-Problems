import java.util.PriorityQueue;

public class MergeKLists {


    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node: lists) {
            if(node!= null)
                minHeap.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;

            if(tail.next!=null) {
                minHeap.offer(tail.next);
            }
        }
        return dummy.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

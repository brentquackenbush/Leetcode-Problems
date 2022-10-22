import java.util.*;

class ReverseSubList {
    //I will move a node until it my integer variable aggregates to  p.
    public static ListNode reverse(ListNode head, int p, int q) {
        if(p==q) return head;

        ListNode cur = head, prev = null;

        for(int i = 0; i < p-1; i++) {
            prev = cur;
            cur = cur.next;
        }
        if(cur==head) return head; //List is of size one.
        ListNode cur2 = cur, prev2 = prev;

        for(int i = p; i <= q; i++) {
            ListNode next = cur2.next;
            cur2.next = prev2;
            prev2 = cur2;
            cur2 = next;
        }
        prev.next = prev2;
        cur.next = cur2;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
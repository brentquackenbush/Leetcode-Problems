import java.util.*;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        for(int i =2; i < 5; i++) {
            add(head,i);
        }
        ListNode headIteratively = head;
        ListNode headRecursively = head;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }

        headIteratively = reverseListIteratively(headIteratively);
        System.out.println();
        System.out.print("This is the iterative algorithm answer: ");
        for(ListNode cur = headIteratively; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
        System.out.println();
        System.out.print("This is the recursive algorithm answer: ");
        headRecursively = reverseListRecursively(headRecursively);
        for(ListNode cur = headRecursively; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }

    }

    public static ListNode reverseListIteratively(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;
        while(head != null ) {
            ListNode next = head.next;
            head.next  = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseListRecursively(ListNode head) {
        return recursiveHelper(head,null);
    }

    public static ListNode recursiveHelper(ListNode head, ListNode prev) {
        if(head == null) return prev;

        ListNode next = head.next;
        head.next = prev;
        return recursiveHelper(next, head);
    }

    public static void add(ListNode head, int val) {

        while(head.next!=null) {
            head = head.next;
        }
        head.next = new ListNode(val);

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  }


}

//Solution: this is O(N) run time complexity because in order to reverse the whole linked list we have to go through the
//entire linked list and reverse its pointers.
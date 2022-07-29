public class MiddleLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        for(int i = 0; i < 10; i ++) {
            ListNode cur = new ListNode(i);
            add(cur,head);
        }

        ListNode ans = middleNode(head);
        System.out.println(ans.val);


    }

    public static void add(ListNode cur,ListNode head) {
        if(head.next == null) {
            head.next = cur;
            return;
        }
        ListNode temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = cur;
    }

    public static ListNode middleNode(ListNode head) {
        if(head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

//Solution: Using a slow pointer and a fast pointer, finding the middle of the list becomes easy. With incrementing the slow pointer by 1 and the
//fast pointer by 2. We Know that once the fast pointer is pointing to null that it reached the end of the list. So then we can just return the slow pointer
//The check in the while loop is important. fast!=null is a check for when the list is at odd length. fast.next!=null is a check for when the list is at even
//length. To make that make sense if fast pointer is incrementing by two and the current position = null. That means we went over the list and that can
//only happen when the list is at odd length. BIG O(n) run time complexity and O(1) space time complexity.
//One pass algorithm.

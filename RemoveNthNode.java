
//Given the head of a linked list, remove the nth node from the end of the list and return its head.
public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        for(int i = 1; i < 6; i ++) {
            ListNode cur = new ListNode(i);
            add(cur,head);
        }

        ListNode ans = RemoveNthNode(head,2);



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

    //I'll be using a slow and fast pointer to remove the Nth node in one pass
    //is there any other way to remove the nth node in one pass without slow and fast pointers?
    public static ListNode RemoveNthNode(ListNode head, int n) {

        ListNode slow = head, fast = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast.next == null) return head.next; //if head is meant to be deleted, return null
        //in the case where interviewer wants the data to be deleted and instead just unpointed to, make sure to set head to null

        while(fast.next !=null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
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

//Solution: Using two pointers: slow and fast. We have fast increment to the n times ahead. If fast.next is already null, that means head is meant to be deleted
//and returned an empty list. TIP(Ask interviewer if you wanted head to be deleted or does it not matter in this scenario)
//Once fast is incremeneted n times, increment both fast and slow pointer until fast.next == null. Once done slow.next should be pointing to the node
//to be deleted. So to unchain the list and remove the pointer to that node, do slow.next = slow.next.next;
//O(n) and it is one pass.
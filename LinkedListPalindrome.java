public class LinkedListPalindrome {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        System.out.println("This is the linked list: ");
        ListNode head = node;
        while(node!=null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        System.out.println("Answer should be True");
        System.out.println("------------------------------");
        System.out.println("isPalindrome function returns: " + isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode walker = head;
        ListNode runner = head;
        ListNode pre = null;
        while(runner!=null && runner.next!=null) {
            runner = runner.next.next; //move runner first, otherwise the next of the head will be already changed
            //reverse linked list
            ListNode nextWalker = walker.next;
            walker.next = pre;
            pre = walker;
            walker = nextWalker;
        }//after this the pre would be the head of our first half, while walker at the head of second half
        if(runner != null) { // odd number length
            walker = walker.next;
        }
        while(pre!=null && walker!=null) {
            if(pre.val != walker.val) return false;
            pre = pre.next;
            walker = walker.next;
        }
        return true;

    }

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}

//This solution reverses half of the linked list and then checks the values from first half beginning to second half beginning
//Still takes O(n) time. The only way to reverse a linked list is to use three pointers.


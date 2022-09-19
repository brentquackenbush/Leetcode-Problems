

class test {

    public static ListNode findCycleStart(ListNode head) {
        if(head == null) return head;
        ListNode slow = head, fast = head;
        int lengthOfCycle = 0;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                ListNode current = slow;
                do {
                    current = current.next;
                    lengthOfCycle++;
                }while(current!=slow);
                break;
            }
        }
        ListNode pointer1 = head, pointer2 = head;
        while (lengthOfCycle > 0) {
            pointer2 = pointer2.next;
            lengthOfCycle--;
        }

        while(pointer1!=pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + test.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + test.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + test.findCycleStart(head).value);
    }
}
public class RemoveDuplicatesFromLinkedList {

    //Given the head of a linked list, remove the nth node from the end of the list and return its head.

        public static void main(String[] args) {
            ListNode head = new ListNode();
            int j = 1;
            for(int i = 1; i < 6; i ++) {
                ListNode cur = new ListNode(i);
                add(cur,head);
                j++;
                if(j%2 == 0) {
                    add(new ListNode(i),head);
                }
            }
            for(ListNode cur = head; cur!=null; cur = cur.next) {
                System.out.print(cur.val + " ");
            }
            System.out.println();
            deleteDuplicates(head);

            for(ListNode cur = head; cur.next!=null; cur = cur.next) {
                System.out.print(cur.val + " ");
            }





        }
    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null) return head; //if List is empty

        ListNode sentinel = new ListNode(0,head); //using a sentinel node to edge case if the head of the node is a duplcate
        ListNode pred = sentinel; //set pred to sentinel

        while(head != null) {
            if(head.next!= null && head.val == head.next.val) { //
                while(head.next !=null && head.val == head.next.val) {
                    head = head.next;

                }
                pred.next = head.next;
            } else {
                pred = pred.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }


        public static void add(ListNode cur, ListNode head) {
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

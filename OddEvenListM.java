public class OddEvenListM{

     // Definition for singly-linked list.
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
        public static void main(String[] args) {
              ListNode nn = new ListNode(1);
              ListNode head = nn;
              for(int i = 2; i < 7; i++) {
                  nn.next = new ListNode(i);
                  nn = nn.next;
              }
              nn = oddEvenList(head);
              while(nn!=null) {
                  System.out.println(nn.val);
                  nn = nn.next;
              }
      }

        public static ListNode oddEvenList(ListNode head) {

            if(head == null || head.next == null) return head;

            ListNode odd = head, even = head.next, evenHead = even;

            while(even !=null && even.next!=null) {
                odd.next = even.next; //point odd.next to next odd indecy,
                odd = odd.next;//move odd
                even.next = odd.next; //move even.next to next even indecy
                even = even.next; //move even
            }
            odd.next = evenHead; //point list back together
            return head;
        }


}

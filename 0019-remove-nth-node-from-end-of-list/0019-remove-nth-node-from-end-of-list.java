/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         int fp=0;
        ListNode temp=head;
        while (head!=null)
        {
            head=head.next;
            fp++;
        }
        int sp=0;
        head=temp;
        ListNode kon=new ListNode(-1);
        temp=kon;
        while (head!=null)
        {
            sp++;
            if(fp-sp+1==n)
            {
                head=head.next;
                continue;
            }
            kon.next= new ListNode(head.val);
            kon=kon.next;
            head=head.next;          
        }
        return  temp.next;
    }
}
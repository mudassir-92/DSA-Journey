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
    public ListNode mergeKLists(ListNode[] lists) {
         int [] arr=new int[100000];
        Arrays.fill(arr,99999);
        int cnt=0;
        for(int i=0;i<lists.length;i++)
            while (lists[i]!=null)
            {
                arr[cnt]=lists[i].val;
                lists[i]=lists[i].next;
                cnt++;
            }
        Arrays.sort(arr);
        ListNode temp=new ListNode(-1);
        ListNode ref=temp;
        int k=0;
    while (arr[k]!=99999)
    {
        temp.next=new ListNode(arr[k]);
        k++;
        temp=temp.next;
    }

        return ref.next;
    }
}
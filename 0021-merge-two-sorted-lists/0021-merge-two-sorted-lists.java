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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          ListNode res=null;
        ListNode head=null;
        boolean flag=true;
        do {
            flag=true;
            while (list1!=null && list2!=null &&list1.val<=list2.val)
            {
                if(res==null)
                {
                    res= new ListNode(list1.val);
                    head=res;
                }
                else
                {
                    res.next=new ListNode(list1.val);
                    res=res.next;
                }
                list1=list1.next;
                flag=false;
            }
            while (list2!=null && list1!=null&&list2.val<=list1.val)
            {
                if(res==null)
                {
                    res= new ListNode(list2.val);
                    head=res;
                }
                else
                {
                    res.next=new ListNode(list2.val);
                    res=res.next;
                }
                flag=false;
                list2=list2.next;
            }
            if(list1==null)
            {
                while (list2!=null)
                {
                    if(res==null)
                    {
                        res= new ListNode(list2.val);
                        head=res;
                    }
                    else
                    {
                        res.next=new ListNode(list2.val);
                        res=res.next;
                    }
                    flag=false;
                    list2=list2.next;
                }
            }
            else if(list2==null)
            {
                if(res==null)
                {
                    res= new ListNode(list1.val);
                    head=res;
                }
                else
                {
                    res.next=new ListNode(list1.val);
                    res=res.next;
                }
                flag=false;
                list1=list1.next;
            }
        }while (!flag);
        return  head;
    }
}
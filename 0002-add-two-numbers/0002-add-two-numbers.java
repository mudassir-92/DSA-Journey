class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode res=new ListNode(-1);
        ListNode dummy=res;
       while (l1!=null || l2!=null)
       {
           int ones=0;
           int seconds=0;
           if(l1!=null){
               ones= l1.val;
           }
           if(l2!=null) {
               seconds= l2.val;
           }
           int curr=carry+ones+seconds;
           if(curr>9) {
               curr=curr%10;
               carry=1;
           }else carry=0;
           res.next=new ListNode(curr);
           res=res.next;
           if(l1!=null){
               l1=l1.next;
           }
           if(l2!=null){
               l2=l2.next;
           }
       }
        if(carry==1)
            res.next=new ListNode(1);
        return dummy.next;
    }
}
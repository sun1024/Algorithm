// https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null) return null;
        // 快慢指针 p1先跑k步，然后和p2一起跑
        ListNode p1 = head;
        for(int i=0; i<k; i++) { 
            if(p1==null) return null; // k>链表长度
            p1 = p1.next;
        }
        ListNode p2 = head;
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
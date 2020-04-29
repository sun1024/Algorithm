// https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
// 递归
// public class Solution {
//     public ListNode ReverseList(ListNode head) {
//         if(head == null|| head.next == null) return head;
//         ListNode res = ReverseList(head.next);
//         head.next.next = head;
//         head.next = null;
//         return res;
//     }
// }
// 迭代
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
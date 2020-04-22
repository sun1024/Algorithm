// https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null || pHead.next==null) return pHead;
        ListNode head = new ListNode(0); // 增加头节点，避免重复处理源头节点
        head.next = pHead;
        // 双指针，cur判断是否重复，pre跳过重复节点
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null) {
            if(cur.next!=null && cur.val==cur.next.val) {
                // 如果存在重复，则一直往下遍历直到不再重复
                while(cur.next!=null && cur.val==cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next; // 退出循环之后再往下一个节点才是不重复的
                pre.next = cur; // pre的下一个指向第一个不重复的节点
            } else {
                pre = cur; // 如果不重复，则当前节点需要保留下来
                cur = cur.next;
            }
        }
        return head.next;
    }
}
// https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
// 反转链表再存入ArrayList
// import java.util.ArrayList;
// public class Solution {
//     public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//         ArrayList<Integer> res = new ArrayList<>();
//         if(listNode == null) return res;
//         listNode = reverse(listNode);
//         while(listNode != null) {
//             res.add(listNode.val);
//             listNode = listNode.next;
//         }
//         return res;
//     }
//     private ListNode reverse(ListNode listNode) {
//         // 递归
//         if(listNode == null || listNode.next == null) return listNode;
//         ListNode head = reverse(listNode.next);
//         listNode.next.next = listNode;
//         listNode.next = null;
//         return head;
//         // 迭代
//         ListNode prev = null;
//         while(listNode != null) {
//             ListNode temp = listNode.next;
//             listNode.next = prev;
//             prev = listNode;
//             listNode = temp;
//         }
//         return prev;
//     }
// }
// 使用栈
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if(listNode == null) return res;
        Stack<Integer> stack = new Stack<>();
        ListNode head = listNode;
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
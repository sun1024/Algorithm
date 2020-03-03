/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (66.86%)
 * Likes:    780
 * Dislikes: 0
 * Total Accepted:    163.3K
 * Total Submissions: 242.8K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 迭代
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode prev = null;
//         while(head != null) {
//             ListNode temp = head.next; //保存当前节点后的所有节点
//             head.next = prev; //将当前节点指向已排好的部分
//             prev = head; //多排好了一个节点
//             head = temp; //剩下的节点重新作为当前节点 迎接下一次循环
//         }
//         return prev;
//     }
// }
// 递归 不是很好理解ORZ
class Solution {
    public ListNode reverseList(ListNode head) {
        //递归终止条件：当前为空或下一个为空
        if(head==null || head.next==null) return head;
        ListNode cur = reverseList(head.next); // cur递归调用后为最后一个节点
        head.next.next = head; // 不断让当前节点的下一个节点指向自己
        head.next = null; // 让head.next置空 防止成环 此时有下一个节点和上一个节点同时指向当前节点
        return cur; //返回最后一个节点 返回时所有节点全部指向相反的方向
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (40.19%)
 * Likes:    407
 * Dislikes: 0
 * Total Accepted:    65K
 * Total Submissions: 160.2K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        //快慢指针找到链表中间 对于后面的部分翻转 与前面比较
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) { //slow刚好走到后半节点
            slow = slow.next;
            fast = fast.next.next;
        }    
        ListNode prev = null;
        while(slow != null) { //反转
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
       }
       while(prev != null) {
           if(head.val != prev.val) return false;
           prev = prev.next;
           head = head.next;
       }
       return true;
    }
}
// @lc code=end


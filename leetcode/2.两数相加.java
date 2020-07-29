/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (33.63%)
 * Likes:    2372
 * Dislikes: 0
 * Total Accepted:    126.3K
 * Total Submissions: 371K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
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
// 两个链表不一样长的话，后面的处理就不太方便，因此直接补齐短的，只用考虑最后的进1
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        // 不能直接用l1 l2 因为后面还要从头遍历
        ListNode node1 = l1;
        ListNode node2 = l2;
        // 先将短的链表补齐
        int len1 = 1;
        int len2 = 1;
        // 不能直接(node != null) 这样会导致最后的node==null
        while(node1.next != null) {
            node1 = node1.next;
            len1++;
        }
        while(node2.next != null) {
            node2 = node2.next;
            len2++;
        }
        // 保证len1>=len2 这样可以少写几行代码
        if(len1 < len2) addTwoNumbers(l2, l1);
        for(int i=0; i<len1-len2; i++) {
            node2.next = new ListNode(0);
            node2 = node2.next;
        }
        // 是否进位
        boolean carry = false;
        ListNode head = new ListNode(0);
        ListNode pHead = head;
        while(l1 != null && l2 != null) {
            int temp = l1.val + l2.val;
            if(carry) {
                temp++;
                carry = false;
            }
            if(temp > 9) {
                pHead.next = new ListNode(temp % 10);
                carry = true;
            } else pHead.next = new ListNode(temp);
            l1 = l1.next;
            l2 = l2.next;
            pHead = pHead.next;
        }
        // 注意pHead和pHead.next
        if(carry) pHead.next = new ListNode(1);
        return head.next;
    }
}
// @lc code=end


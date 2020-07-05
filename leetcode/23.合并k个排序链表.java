import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (51.61%)
 * Likes:    772
 * Dislikes: 0
 * Total Accepted:    138.9K
 * Total Submissions: 266.4K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
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
// 全部存入数组，暴力排序
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists.length == 0) return null;

//         ArrayList<Integer> temp = new ArrayList<>();
//         // 将全部元素存入temp
//         for(ListNode list:lists) {
//             while(list != null) {
//                 temp.add(list.val);
//                 list = list.next;
//             }
//         }
//         // 对temp排序
//         Collections.sort(temp);
//         ListNode head = new ListNode(0); // 记住新建链表的写法
//         ListNode res = head;
//         for(int i=0; i<temp.size(); i++) {
//             // 原本res.next指向null, 现在让它指向一个val为temp.get(i)的链表
//             res.next = new ListNode(temp.get(i));
//             res = res.next;
//         }
//         return head.next;
//     }
// }
// 依次合并两条链表 O(NK)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode res = null;
        for(ListNode list:lists) {
            res = merge2Lists(res, list);
        }
        return res;
    }
    // // 递归合并两条链表
    // private ListNode merge2Lists(ListNode list1, ListNode list2) {
    //     if(list1 == null) return list2;
    //     if(list2 == null) return list1;
    //     if(list1.val < list2.val) {
    //         list1.next = merge2Lists(list1.next, list2);
    //         return list1;
    //     }
    //     list2.next = merge2Lists(list1, list2.next);
    //     return list2;
    // }
    // // 迭代合并两条链表
    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if(list1 == null) {
            head.next = list2;
        } else {
            head.next = list1;
        }
        return res.next;
    }
}
// @lc code=end


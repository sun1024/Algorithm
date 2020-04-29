// https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
// 迭代
// public class Solution {
//     public ListNode Merge(ListNode list1,ListNode list2) {
//         ListNode res = new ListNode(0); // 定义头结点
//         ListNode curr = res;
//         while(list1 != null && list2 != null) {
//             if(list1.val > list2.val) {
//                 curr.next = list2;
//                 list2 = list2.next;
//             } else {
//                 curr.next = list1;
//                 list1 = list1.next;
//             }
//             curr = curr.next;
//         }
//         if(list1 != null) curr.next = list1;
//         else curr.next = list2;
//         return res.next; // 返回头结点的下一个
//     }
// }
// 递归
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val > list2.val) {
            // 改变指针结构 让当前较小节点不停的指向下一节点的merge
            list2.next = Merge(list1, list2.next); 
            //递归结束 return的是list1和list2中较小的头结点 并且完成了两个链表的合并
            return list2; 
        } else {
            list1.next = Merge(list1.next, list2);
            return list1;
        }
    }
}
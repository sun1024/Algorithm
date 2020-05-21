// https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 1.暴力两层循环，找到第一个相等的node O(mn) 前提是链表没有成环
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        while(pHead1 != null) {
            ListNode temp = pHead2;
            while(temp != null) {
                if(temp == pHead1) return temp;
                temp = temp.next;
            }
            pHead1 = pHead1.next;
        }
        return null;
    }
}
// 2.hashset/hashmap 时间:O(n+m) 空间:O(n) 把pHead1的所有结点存入hashset,遍历一次pHead2的结点比较是否相等
// 因为node1==node2则代表结点剩下所有部分都相等
import java.util.HashSet;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        while(pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null) {
            if(set.contains(pHead2)) return pHead2;
            pHead2= pHead2.next;
        }
        return null;
    }
}
// 3.双指针 时间:O(n+m) 空间:O(1)
// 只要我们有交集，终会在一起 单身狗看题解看哭了qaq
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2) { 
            if(p1 != null) p1 = p1.next; 
            else p1 = pHead2; // p1遍历完又从p2开始
            if(p2 != null) p2 = p2.next;
            else p2 = pHead1; // p2遍历完又从p1开始
        }
        return p1; // 相等的时候两个指针走了同样长的路程
    }
}
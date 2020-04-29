// https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
// HashSet
// import java.util.HashSet;
// public class Solution {

//     public ListNode EntryNodeOfLoop(ListNode pHead)
//     {
//         if(pHead == null) return null;
//         HashSet<ListNode> set = new HashSet<>();
//         ListNode cur = pHead;
//         while(cur != null) {
//             if(!set.contains(cur)) {
//                 set.add(cur);
//                 cur = cur.next;
//             } else {
//                 break;
//             }
//         }
//         return cur;
//     }
// }
// 快慢指针
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if(p1 == p2) { // 有环
                p1 = pHead; // 相遇时 p1跑了x p2跑了2x 它们离环的距离的1倍或者n倍==从头跑到环的距离
                while(p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
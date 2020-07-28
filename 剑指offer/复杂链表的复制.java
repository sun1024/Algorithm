// https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&&tqId=11178&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
// 深拷贝个人理解就是重新开辟内存空间拷贝
// 主要在于random指向不好处理，需要记录下新旧节点的对应关系
import java.util.*;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return pHead;
        // 使用map存下新旧节点对应关系
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = pHead;
        while(node != null) {
            RandomListNode temp = new RandomListNode(node.label);
            map.put(node, temp);
            node = node.next;
        }
        // 重新回到根节点
        node = pHead;
        // 再次遍历，连接新节点的next和random指向关系
        while(node != null) {
            RandomListNode temp = map.get(node);
            temp.next = map.get(node.next);
            temp.random = map.get(node.random);
            node = node.next;
        }
        return map.get(pHead);
    }
}
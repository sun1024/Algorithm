// https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
// 通过不断next找到根节点，然后中序遍历匹配上pNode的下一个节点
import java.util.ArrayList;
public class Solution {
    ArrayList<TreeLinkNode> list = new ArrayList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;
        TreeLinkNode fa = pNode;
        // 找根节点
        while(fa.next != null) {
            fa = fa.next;
        }
        // 中序遍历,顺便把值存进list
        Inorder(fa);
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) == pNode) {
                return list.get(i+1); // 这里要保证i+1存在，所以上面i<list.size()-1
            }
        }
        return null;
    }
    // 中序遍历 左中右
    private void Inorder(TreeLinkNode pNode) {
        if(pNode == null) return;
        Inorder(pNode.left);
        list.add(pNode);
        Inorder(pNode.right);
    }
}
// 从中序遍历的过程出发，不依赖根节点即可找到：
// pNode有右子树，则下一个节点是右子树中最左边的节点
// pNode无右子树，且pNode是父节点的左孩，则下一个节点为其父节点：pNode.next
// pNode无右子树，且pNode是父节点的右孩，则需要从pNode.next开始不断往上找，下一个节点为第一个是其父节点左孩的节点

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;
        if(pNode.right != null) {
            return GetLeft(pNode.right); // 求右子树中最左边的节点
        } else {
            if(pNode.next == null) return null;
            if(pNode.next.left == pNode) {
                return pNode.next;
            } else {
                return GetDadLeft(pNode.next); // 求第一个是他爸爸的左儿子的节点
            }
        }
        
    }

    private TreeLinkNode GetLeft(TreeLinkNode pNode) {
        if(pNode.left == null) return pNode;
        return GetLeft(pNode.left);
    }

    private TreeLinkNode GetDadLeft(TreeLinkNode pNode) {
        if(pNode.next == null) return null;
        if(pNode.next.left == pNode) return pNode.next;
        return GetDadLeft(pNode.next);
    }
}
// https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&&tqId=11157&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// leetcode 105 再敲一遍加深印象
import java.util.HashMap;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int preLength = pre.length;
        int inLength = in.length;
        if(inLength != preLength) return null; // 这个判断可以不要
        for(int i=0; i<inLength; i++) {
            map.put(in[i], i);
        }
        // 注意len-1
        return reConstructBinaryTree(pre, in, 0, preLength-1, 0, inLength-1);
    }
    
    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int preL, int preR, int inL, int inR) {
        if(preL>preR || inL>inR) return null; // 递归结束条件
        
        TreeNode root = new TreeNode(pre[preL]); // 不知道为什么TreeNode()的写法突然又不行了
        int index = map.get(root.val);
        // 边界的部分要列式算下
        root.left = reConstructBinaryTree(pre, in, preL+1, index-inL+preL, inL, index-1);
        root.right = reConstructBinaryTree(pre, in, index-inL+preL+1, preR, index+1, inR);
        return root;
    }
}
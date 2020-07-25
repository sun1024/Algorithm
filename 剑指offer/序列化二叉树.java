// https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&&tqId=11214&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
import java.util.*;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
// 层次遍历，遇到空节点用特定字符标记，反序列化再层次遍历一次即可
public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        // 根节点为空，直接返回空字符串，在反序列化是处理即可
        if(root == null) return ""; 
        // 层次遍历
        bfs(root, sb);
        return sb.toString();
    }
    
    private void bfs(TreeNode root, StringBuilder sb) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp != null) { 
                sb.append(temp.val + ";");
                // 和普通层次遍历不同的是不用判断节点是否为空，为空也要进行记录
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                sb.append("#;"); // 记录空节点
            }
        }
    }
    
    TreeNode Deserialize(String str) {
        // 处理空树
        if(str == null || str.length() == 0) return null;
        String[] res = str.split(";"); // split()方法不要忘了
        // 再次层次遍历
        return buildTree(res);
    }
    
    private TreeNode buildTree(String[] res) {
        // Integer.parseInt() 转换
        TreeNode root = new TreeNode(Integer.parseInt(res[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 第0个就是root，所以从1开始装进树里
        int index = 1;
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            // 先装左边再装右边
            if(!res[index].equals("#")) {
                temp.left = new TreeNode(Integer.parseInt(res[index]));
                queue.add(temp.left);
            } else {
                temp.left = null;
            }
            index++;
            if(!res[index].equals("#")) {
                temp.right = new TreeNode(Integer.parseInt(res[index]));
                queue.add(temp.right);
            } else {
                temp.right = null;
            }
            index++;
        }
        return root;
    }
}
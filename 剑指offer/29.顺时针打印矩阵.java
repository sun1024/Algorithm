// https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 有点打脑壳。。。
// 明确过程是顺时针对矩阵进行扫描，分为四个步骤，每执行一步，边界缩小一次
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        // 左右上下 四个边界
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;
        while(true) { // 边界条件放在边界缩小的时候处理，逻辑跟清晰
            // 从左往右
            for(int i=left; i<=right; i++) {
                res.add(matrix[up][i]);
            }
            if(++up>down) break; // 第一行扫完，上边界就从第二行开始，依次增加
            // 从上往下
            for(int j=up; j<=down; j++) {
                res.add(matrix[j][right]); 
            }
            if(--right<left) break; // 最后一列扫完，右边界就从倒数第二列开始，依次减少
            // 从右往左
            for(int k=right; k>=left; k--) {
                res.add(matrix[down][k]);
            }
            if(--down<up) break; // 最后一行扫完，下边界就从倒数第二行开始，依次减少
            // 从下往上
            for(int m=down; m>=up; m--) {
                res.add(matrix[m][left]);
            }
            if(++left>right) break; // 第一列扫完，左边界就从第二列开始，依次增加
        }
        return res;
    }
}
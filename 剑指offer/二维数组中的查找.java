// https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
// // 第一印象 对每一行二分 O(nlogn)
// import java.util.*;
// public class Solution {
//     public boolean Find(int target, int [][] array) {
//         int len = array.length-1;
//         if(len == 0) return false;
//         if(target < array[0][0] || target > array[len][len]) {
//             return false;
//         }
//         for(int i=0; i<array.length; i++) {
//             if(target<array[i][0]) return false;
//             if(target>array[i][len]) continue;
//             int res = Arrays.binarySearch(array[i], target);
//             if(res>=0) return true;
//         }
//         return false;
//     }
// }
// 站在右上角 使用双指针 O(n+m)
public class Solution {
    public boolean Find(int target, int [][] array) {
        int hang = array.length;
        int lie = array[0].length;
        // 初始化到右上角
        int p1 = 0;
        int p2 = lie-1;
        while(p1<hang && p2>=0) {
            int temp = array[p1][p2];
            if(temp == target) return true;
            else if(target > temp) { //大了就往下
                p1++;
            } else { //小了就往左
                p2--;
            }
        }
        return false;
    }
}
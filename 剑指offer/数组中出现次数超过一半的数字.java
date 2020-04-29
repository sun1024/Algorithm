// https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// hashmap O(0)
// import java.util.HashMap;
// public class Solution {
//     public int MoreThanHalfNum_Solution(int [] array) {
//         // 两个特殊情况
//         if(array.length==0) return 0;
//         if(array.length==1) return array[0];
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int res = 0;
//         for(int i:array) {
//             if(map.containsKey(i)) {
//                 map.put(i, map.get(i)+1);
//                 if(map.get(i)>array.length/2) {
//                     return i;
//                 }
//             } else {
//                 map.put(i, 1);
//             }
//         }
//         return 0;
//     }
// }
// 不用hashmap O(n)
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==0) return 0;
        int prev= array[0]; // 记录前面出现最多的值
        int count = 0; // 出现的次数
        for(int i:array) {
            if(i==prev) count++; // 相等则次数增加
            else {
                count--; // 不等则抵消一个
                if(count==0) { //抵消为零则换成当前值 重新计算
                    prev = i;
                    count = 1;
                }
            }
        }
        int num = 0; //需要确认是否超过一半
        for(int i:array) {
            if(i==prev) num++;
            if(num>array.length/2) return prev;
        }
        return 0;
    }
}
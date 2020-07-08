// https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&&tqId=11198&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 阅读理解题，理解清楚就很好做，除开0以外的数中最大值-最小值之差小于5即可凑成顺子
// 1. 直接拿hashset过一遍，排除掉0和重复，同时可以得到最值，相减即可 
// 时间：O(n)  空间：O(n)
// import java.util.HashSet;
// public class Solution {
//     public boolean isContinuous(int [] numbers) {
//        if(numbers.length != 5) return false;
//         HashSet<Integer> set = new HashSet<>();
//         // 最值初始化为极端值
//         int max = 0; 
//         int min = 14;
//         for(int i:numbers) {
//             if(set.contains(i)) return false; // 有重复必不可能构成顺子
//             if(i == 0) continue;
//             max = Math.max(max, i);
//             min = Math.min(min, i);
//             set.add(i);
//         }
//         if(max-min < 5) return true;
//         return false;
//     }
// }
// 2.排序，从头遍历统计0的个数，count(0)+1即为min, 末尾为max，max-min<5
// 时间：O(nlogn)  空间：O(1)
import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5) return false;
        Arrays.sort(numbers);
        int jokers = 0; 
        for(int i=0; i<5-1; i++) {
            if(numbers[i] == 0) jokers++;
            else if(numbers[i] == numbers[i+1]) return false; // 除开0之外有相同的数就不能构成顺子
        }
        if(numbers[4]-numbers[jokers] < 5) return true;
        return false;
    }
}

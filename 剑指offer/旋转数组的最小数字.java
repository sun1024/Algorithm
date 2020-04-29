// https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 暴力从头找
// import java.util.ArrayList;
// public class Solution {
//     public int minNumberInRotateArray(int [] array) {
//         int temp = array[0];
//         for(int i:array) {
//             if(i>temp) temp = i;
//             if(i<temp) return i;
//         }
//         return 0;
//     }
// }
// 二分
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        while(left<=right) { 
            int mid = left + (right - left) / 2;
            if(array[right]>array[mid]) { // 说明right还在旋转后的部分
                right = mid;
            } else if(array[right]<array[mid]) { // 说明mid处于旋转前的部分
                left = mid + 1;
            } else { // 相等则right在旋转后 left在旋转前 不断缩小right 进行去重
                right--;
            }
        }
        return array[left];
    }
}
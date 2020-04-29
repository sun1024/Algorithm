// https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 使用额外空间，两次遍历排序，一次遍历拷贝
public class Solution {
    public void reOrderArray(int [] array) {
        int[] res = new int[array.length];
        int index = 0;
        int i = 0;
        while(index<array.length) {
            if(array[index] % 2 != 0) {
                res[i] = array[index];
                i++;
            }
            index++;
        }
        index = 0;
        while(index<array.length) {
            if(array[index] % 2 == 0) {
                res[i] = array[index];
                i++;
            }
            index++;
        }
        for(int j=0; j<array.length; j++) {
            array[j] = res[j];
        }
    }
}
// 尝试冒泡结果超时了。。。
// public class Solution {
//     public void reOrderArray(int [] array) {
//         int len = array.length;
//         if(len<2) return;
//         int i = 0;
//         while(i<len) {
//             int j = i+1;
//             // array[i]是偶数，则进行调整
//             if(array[i]%2 == 0) {
//                 while(array[j]%2 == 0) {
//                     if(j == len-1) return;//i之后全是偶数了
//                     j++;
//                 }
//                 count = j-i; //此时的array[j]为奇数，count是要调整的个数
//                 int temp = array[i];
//                 array[i] =  array[j];
//                 while(count>1) { //i与j在循环之外对换，所以count应该少算一个
//                     array[i+count] = array[i+count-1];
//                 }
//                 array[j] = temp;
//             }
//             i++;
//         }
//     }
// }
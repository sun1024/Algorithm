// https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 排序后查找重复 O(nlogn)
// import java.util.*;
// public class Solution {
//     // Parameters:
//     //    numbers:     an array of integers
//     //    length:      the length of array numbers
//     //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
//     //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
//     //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
//     // Return value:       true if the input is valid, and there are some duplications in the array number
//     //                     otherwise false
//     public boolean duplicate(int numbers[],int length,int [] duplication) {
//         if(length == 0) return false;
//         Arrays.sort(numbers);
//         for(int i=1; i<length; i++) {
//             if(numbers[i]==numbers[i-1]) {
//                 duplication[0] = numbers[i];
//                 return true;
//             }
//         }
//         return false;
//     }
// }
// set记录是否重复 O(n)
import java.util.*;
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for(int i:numbers) {
            if(set.contains(i)) {
                duplication[0] = i;
                return true;
            } 
            set.add(i);
        }
        return false;
    }
}
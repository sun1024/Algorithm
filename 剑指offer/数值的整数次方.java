// https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 直接循环
public class Solution {
    public double Power(double base, int exponent) {
        // double res = 1;
        // int abs = Math.abs(exponent);
        // for(int i=0; i<abs; i++) {
        //     res = res*base;
        // }
        // if(exponent<0) return 1/res;
        // return res;
        
        // 更好的处理负指数
        if(exponent<0) {
            base = 1/base;
            exponent = -exponent;
        }
        double res = 1;
        for(int i=0; i<exponent; i++) {
            res = res*base;
        }
        return res;
  }
}
// 递归(快速幂)
public class Solution {
    public double Power(double base, int exponent) {
        // 底数为0则返回1 0的0次方没意义就不做处理
        if(base == 0) return 0.0;
        if(exponent<0) { 
            base = 1/base;
            exponent = -exponent;
        }
        return re_Power(base, exponent);
    }

    public double re_Power(double base, int exponent) {
        // 递归退出条件
        if(exponent == 0) return 1.0;
        if(exponent == 1) return base;
        // if(exponent%2 ==1) {
        if((exponent&1) == 1) { // &1判断奇偶 注意&和==的运算优先级
            // return re_Power(base, exponent/2) * re_Power(base, exponent/2) * base;
            return re_Power(base, exponent>>1) * re_Power(base, exponent>>1) * base; // 右移除2 左移乘2
        } else {
            return re_Power(base, exponent>>1) * re_Power(base, exponent>>1);
        }
    }
}
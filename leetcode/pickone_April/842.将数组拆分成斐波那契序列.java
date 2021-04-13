import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=842 lang=java
 *
 * [842] 将数组拆分成斐波那契序列
 */

// @lc code=start
class Solution {
    // List<Integer> finalResult = new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        backTracing(0, result, S.toCharArray());
        return result;
    }

    private boolean backTracing(int start, List<Integer> ans, char[] chars){
        if(start == chars.length && ans.size() >= 3){
            // finalResult = ans;
            return true;
        }
        for(int i = start; i < chars.length; i++){
            if('0' == chars[start] && i > start){
                break;
            }
            long num = subDigit(chars, start, i + 1);
            if(num > Integer.MAX_VALUE){
                break;
            }
            if(ans.size() >= 2 && num > ans.get(ans.size() - 1) + ans.get(ans.size() - 2)){
                break;
            }
            if(ans.size() <= 1 || num == ans.get(ans.size() - 1) + ans.get(ans.size() - 2)){
                ans.add((int)num);
                if(backTracing(i + 1, ans, chars)){
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;

    }

    private long subDigit(char[] chars, int start, int end){
        long num = 0l;
        for(int i = start; i < end; i++){
            num = num * 10 + chars[i] - '0';
        }
        return num;
    }


    // public List<Integer> splitIntoFibonacci(String S) {
    //     List<Integer> res = new ArrayList<>();
    //     backtrack(S.toCharArray(), res, 0);
    //     return res;
    // }

    // public boolean backtrack(char[] digit, List<Integer> res, int index) {
    //     //边界条件判断，如果截取完了，并且res长度大于等于3，表示找到了一个组合。
    //     if (index == digit.length && res.size() >= 3) {
    //         return true;
    //     }
    //     for (int i = index; i < digit.length; i++) {
    //         //两位以上的数字不能以0开头
    //         if (digit[index] == '0' && i > index) {
    //             break;
    //         }
    //         //截取字符串转化为数字
    //         long num = subDigit(digit, index, i + 1);
    //         //如果截取的数字大于int的最大值，则终止截取
    //         if (num > Integer.MAX_VALUE) {
    //             break;
    //         }
    //         int size = res.size();
    //         //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
    //         if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
    //             break;
    //         }
    //         if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
    //             //把数字num添加到集合res中
    //             res.add((int) num);
    //             //如果找到了就直接返回
    //             if (backtrack(digit, res, i + 1))
    //                 return true;
    //             //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
    //             res.remove(res.size() - 1);
    //         }
    //     }
    //     return false;
    // }

    // //相当于截取字符串S中的子串然后转换为十进制数字
    // private long subDigit(char[] digit, int start, int end) {
    //     long res = 0;
    //     for (int i = start; i < end; i++) {
    //         res = res * 10 + digit[i] - '0';
    //     }
    //     return res;
    // }



}
// @lc code=end


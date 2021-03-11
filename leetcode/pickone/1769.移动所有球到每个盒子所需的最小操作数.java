/*
 * @lc app=leetcode.cn id=1769 lang=java
 *
 * [1769] 移动所有球到每个盒子所需的最小操作数
 */

// @lc code=start
class Solution {
    // public int[] minOperations(String boxes) {
    //     int[] result = new int[boxes.length()];
    //     char[] chars = boxes.toCharArray();
    //     for(int i = 0; i < boxes.length(); i++){
    //         int sum = 0;
    //         for(int j = 0; j < chars.length; j++){
    //             if(chars[j] == '1'){
    //                 sum += Math.abs(j - i);
    //             }
    //         }
    //         result[i] = sum;
    //     }
    //     return result;
    // }


    public int[] minOperations(String boxes){
        // left是左边及当前的1    right是右边1
        int left = 0, right = 0, total = 0;
        char[] chars = boxes.toCharArray();
        int[] result = new int[boxes.length()];
        if(chars[0] == '1'){
            left++;
        }
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == '1'){
                right++;
                total += i;
            }
        }
        result[0] = total;
        for(int i = 1; i < chars.length; i++){
            total = total + left - right;
            if(chars[i] == '1'){
                left++;
                right--;
            }
            result[i] = total;
        }
        return result;

    }

}
// @lc code=end


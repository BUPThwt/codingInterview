import jdk.internal.org.jline.utils.Curses;

/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */

// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 1){
                customers[i] *= -1;
            }
            if(customers[i] > 0){
                sum += customers[i];
            }
        }
        int maxEffect = Integer.MAX_VALUE;
        int subEffect = 0;
        for(int i = 0, j = 0; i < customers.length; i++){
            if(customers[i] < 0){
                subEffect += customers[i];
            }
            if(i - j + 1 > X){
                if(customers[j] < 0){
                    subEffect -= customers[j];
                }
                j++;
            }
            maxEffect = Math.min(maxEffect, subEffect);
        }
        return sum - maxEffect;
    }

    // public int maxSatisfied(int[] customers, int[] grumpy, int X){
    //     int sum = 0;
    //     for(int i = 0; i < customers.length; i++){
    //         if(grumpy[i] == 0){
    //             sum += customers[i];
    //             customers[i] = 0;
    //         }
    //     }
    //     int cur = 0;
    //     int max = 0;
    //     // 滑动窗口维持一个X的窗口，计算窗口内的最大值
    //     for(int i = 0, j = 0; i < customers.length; i++){
    //         cur += customers[i];
    //         if(i - j + 1 > X){
    //             cur -= customers[j++];
    //         }
    //         max = Math.max(cur, max);
    //     }
    //     return sum + max;
    // }
}
// @lc code=end


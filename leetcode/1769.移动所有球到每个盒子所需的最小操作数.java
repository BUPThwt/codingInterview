import javax.swing.Box;


/*
 * @lc app=leetcode.cn id=1769 lang=java
 *
 * [1769] 移动所有球到每个盒子所需的最小操作数
 */

// @lc code=start
class Solution {
    public int[] minOperations(String boxes) {
        // 计算左边1的个数，右边1的个数，初始状态当前1算左边的，
        // 计算初始total为需要移动的部署
        // 从1 开始遍历，total变化为左边+1， 右边-1
        // 如果遍历的当前值为1，则left++, right--;
        int[] ans = new int[boxes.length()];
        int left = 0, right = 0, total = 0;
        if(boxes.charAt(0) == '1'){
            left++;
        }
        for(int i = 1; i < boxes.length(); i++){
            if(boxes.charAt(i) == '1'){
                right++;
                total += i;
            }
        }
        ans[0] = total;
        for(int i = 1; i < boxes.length(); i++){
            total = total + left  - right;
            if(boxes.charAt(i) == '1'){
                left++;
                right--;
            }
            ans[i] = total;
        }
        return ans;
    }
}
// @lc code=end


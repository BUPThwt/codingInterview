import java.security.interfaces.RSAKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        // Arrays.fill(result, -1);
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                map.put(nums2[stack.peek()], nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return result;
    }
}
// @lc code=end


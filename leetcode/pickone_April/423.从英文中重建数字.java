import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=423 lang=java
 *
 * [423] 从英文中重建数字
 */

// @lc code=start
class Solution {
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int[] number = new int[10];
        //zero
        number[0] = map.getOrDefault('z', 0);
        number[2] = map.getOrDefault('w', 0);
        // letter "u" is present only in "four"
        number[4] = map.getOrDefault('u', 0);
        // letter "x" is present only in "six"
        number[6] = map.getOrDefault('x', 0);
        // letter "g" is present only in "eight"
        number[8] = map.getOrDefault('g', 0);
        // letter "h" is present only in "three" and "eight"
        number[3] = map.getOrDefault('h', 0) - number[8];
        // letter "f" is present only in "five" and "four"
        number[5] = map.getOrDefault('f', 0) - number[4];
        // letter "s" is present only in "seven" and "six"
        number[7] = map.getOrDefault('s', 0) - number[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        number[9] = map.getOrDefault('i', 0) - number[5] - number[6] - number[8];
        // letter "n" is present in "one", "nine", and "seven"
        number[1] = map.getOrDefault('n', 0) - number[7] - 2 * number[9];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length; i++){
            while(number[i] > 0){
                sb.append(i);
                number[i]--;
            }
        }
        return sb.toString();


    }
}
// @lc code=end

